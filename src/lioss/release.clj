(ns lioss.release
  (:require [lioss.pom :as pom]
            [lioss.git :as git]
            [lioss.subshell :as subshell]
            [lambdaisland.regal :as regal]
            [clojure.java.io :as io]
            [lioss.util :as util]
            [clojure.string :as str]))

(defn module-versions [{:keys [name group-id version modules]}]
  (into {(symbol group-id name) version}
        (map (fn [[_ {:keys [name group-id version]}]]
               [(symbol group-id name) version]))
        modules))

(defn override-versions [opts versions]
  (update
   opts
   :deps
   (fn [deps]
     (reduce
      (fn [deps [artifact version]]
        (if (contains? deps artifact)
          (assoc deps artifact {:mvn/version version})
          deps))
      deps
      versions))))

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

(defn bump-changelog [{:keys [version date sha]}]
  (let [blob (slurp "CHANGELOG.md")
        lines (str/split blob #"\R")]
    (spit "CHANGELOG.md"
          (str/join "\n"
                    (cons
                     (str "# " version " (" date " / " (subs sha 0 7) ")")
                     (next lines))))))

(defn changelog-stanza []
  (let [blob (slurp "CHANGELOG.md")
        lines (str/split blob #"\R")]
    (str/join "\n"
              (cons
               (first lines)
               (take-while #(not (re-find #"^# " %)) (next lines))))))

(defn mvn-deploy [_]
  (subshell/spawn "mvn" "deploy"))

(defn prepend-changelog-placeholders []
  (spit "CHANGELOG.md"
        (str
         "# Unreleased\n\n## Added\n\n## Fixed\n\n## Changed\n\n"
         (slurp "CHANGELOG.md"))))

(defn do-release [opts]
  (let [mod-vers (module-versions opts)
        opts (update (override-versions opts mod-vers)
                     :modules
                     (fn [mods]
                       (into {}
                             (map (juxt key (comp #(override-versions % mod-vers) val)))
                             mods)))]

    (git/assert-branch "master")
    (git/assert-repo-clean)
    (when (.exists (io/file "tests.edn"))
      (let [res (subshell/spawn "bin/kaocha")]
        (when (not= 0 res)
          (util/fatal "Tests failed, aborting release."))))

    (git/clean!)
    (update-versions-in "README.md" mod-vers)
    (bump-changelog opts)
    (git/git! "add" "-A")
    (git/git! "commit" "-m" (changelog-stanza))
    (git/git! "tag" (str "v" (:version opts)))

    (let [sha (git/current-sha)
          opts (update (assoc opts :sha sha)
                       :modules
                       (fn [mods]
                         (into {}
                               (map (juxt key (comp #(assoc % :sha sha) val)))
                               mods)))]
      (pom/spit-poms opts)
      (util/do-modules opts mvn-deploy)
      (mvn-deploy opts)
      (prepend-changelog-placeholders)
      (git/git! "add" "CHANGELOG.md")
      (git/git! "commit" "-m" "Add CHANGELOG.md placeholders")
      (git/git! "push" "--tags" "master"))))
