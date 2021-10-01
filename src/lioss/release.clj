(ns lioss.release
  (:require [lioss.pom :as pom]
            [lioss.git :as git]
            [lioss.subshell :as subshell]
            [lambdaisland.regal :as regal]
            [clojure.java.io :as io]
            [lioss.util :as util]
            [clojure.string :as str]))

(defn update-versions-in [file versions]
  (let [blob (slurp file)]
    (spit file
          (reduce
           (fn [blob [k v]]
             (-> blob
                 (str/replace (regal/regex
                               [:cat (str k)
                                [:capture
                                 [:+ :whitespace]
                                 "{"
                                 [:* :whitespace]
                                 ":mvn/version"
                                 [:+ :whitespace]
                                 "\""]
                                [:+ [:not "\""]]
                                [:capture
                                 "\""
                                 [:* :whitespace]
                                 "}"]])
                              (str k "$1" v "$2" ))
                 (str/replace (regal/regex
                               [:cat
                                [:capture
                                 "[" (str k)
                                 [:+ :whitespace]
                                 "\""]
                                [:+ [:not "\""]]
                                [:capture
                                 "\""
                                 [:* :whitespace]
                                 "]"]])
                              (str "$1" v "$2" ))))
           blob
           versions))))

(defn bump-changelog [{:keys [version date sha] :as opts}]
  (let [blob (slurp "CHANGELOG.md")
        lines (str/split blob #"\R")]
    (spit "CHANGELOG.md"
          (str/join "\n"
                    (cons
                     (str "# " version " (" date " / " (subs sha 0 7) ")")
                     (next lines))))))

(defn changelog-stanza
  ([]
   (changelog-stanza "CHANGELOG.md"))
  ([file]
   (let [blob (slurp file)
         lines (str/split blob #"\R")]
     (str/join "\n"
               (cons
                (first lines)
                (take-while #(not (re-find #"^# " %)) (next lines)))))))

(defn mvn [& args]
  (apply subshell/spawn "mvn" args))

(defn prepend-changelog-placeholders []
  (spit "CHANGELOG.md"
        (str
         "# Unreleased\n\n## Added\n\n## Fixed\n\n## Changed\n\n"
         (slurp "CHANGELOG.md"))))

(defn trigger-cljdoc-build [opts]
  (subshell/spawn
   "curl" "-v" "-XPOST" "https://cljdoc.org/api/request-build2"
   "-d" (str "project=" (str (:group-id opts) "/" (:name opts)))
   "-d" (str "version=" (:version opts))))

(defn print-versions [opts]
  (binding [*print-namespace-maps* false]
    (let [project (symbol (:group-id opts) (:name opts))]
      (prn `[~project ~(:version opts)])
      (prn `{~project {:mvn/version ~(:version opts)}}))))

(defn do-release [opts]
  (git/assert-branch #{"master" "main"})
  (git/assert-repo-clean)
  (when (and (.exists (io/file "tests.edn")) (not (System/getenv "SKIP_TESTS")))
    (subshell/spawn "bin/kaocha" {:fail-message "Tests failed, aborting release."}))

  (git/clean!)

  (let [opts (if-let [hook (:pre-release-hook opts)]
               (let [opts (hook opts)]
                 (when (nil? opts)
                   (println ":pre-release-hook returned nil!")
                   (System/exit 1))
                 opts)
               opts)]
    (update-versions-in "README.md" (:module-versions opts))
    (bump-changelog opts)
    (git/git! "add" "-A")
    (git/git! "commit" "-m" (changelog-stanza))
    (git/git! "tag" (str "v" (:version opts)))

    (let [sha (git/current-sha)
          opts (update (assoc opts :sha sha)
                       :modules
                       (fn [mods]
                         (map #(assoc % :sha sha) mods)))
          opts (cond-> opts
                 (.exists (io/file "AUTHORS"))
                 (assoc :authors (str/split (str/trim (slurp "AUTHORS")) #"\R")))]
      (pom/spit-poms opts)
      (util/do-modules opts (fn [_] (mvn "deploy")))
      (mvn "deploy")
      (prepend-changelog-placeholders)
      (git/git! "add" "pom.xml")
      (util/do-modules opts (fn [_] (git/git! "add" "pom.xml")))
      (git/git! "add" "CHANGELOG.md")
      (git/git! "commit" "-m" "Update pom.xml and add CHANGELOG.md placeholders")
      (git/git! "push" "--tags")
      (git/git! "push")

      (trigger-cljdoc-build opts)
      (util/do-modules opts trigger-cljdoc-build)

      (print-versions opts)

      (when-let [hook (:post-release-hook opts)]
        (hook opts)))))

(defn do-install [opts]
  (let [opts (if-let [hook (:pre-release-hook opts)]
               (let [opts (hook opts)]
                 (when (nil? opts)
                   (println ":pre-release-hook returned nil!")
                   (System/exit 1))
                 opts)
               opts)]

    (let [sha (git/current-sha)
          opts (update (assoc opts :sha sha)
                       :modules
                       (fn [mods]
                         (map #(assoc % :sha sha) mods)))]
      (pom/spit-poms opts)
      (util/do-modules opts (fn [_] (mvn "install")))
      (mvn "install"))))
