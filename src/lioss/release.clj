(ns lioss.release
  "Cutting new releases of libraries, handles the whole rigamarole

  - runs test (use SKIP_TESTS=1 to skip)
  - bump version
  - update pom.xml
  - build and upload jar
  - update version strings in README
  - add new stanza to the top of the CHANGELOG
  - create a new release on Github
  - trigger a cljdoc build"
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [lioss.git :as git]
            [lioss.github :as github]
            [lioss.pom :as pom]
            [lioss.subshell :as subshell]
            [lioss.util :as util]
            [lioss.version :as version]))

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

  (version/bump-version!)

  (let [opts (version/add-version-info opts)
        opts (assoc opts :release-title (when (seq (:argv opts))
                                          (str/join " " (:argv opts))))
        opts (if-let [hook (:pre-release-hook opts)]
               (let [opts (hook opts)]
                 (when (nil? opts)
                   (println ":pre-release-hook returned nil!")
                   (System/exit 1))
                 opts)
               opts)
        _    (bump-changelog opts)
        opts (assoc opts
                    :changelog (changelog-stanza)
                    :release-tag (str "v" (:version opts)))]
    (version/update-versions-in "README.md" (:module-versions opts))
    (git/git! "add" "-A")
    (git/git! "commit" "-m" (:changelog opts))
    (git/git! "tag" (:release-tag opts))

    (let [sha (git/current-sha)
          opts (update (assoc opts :sha sha)
                       :modules
                       (fn [mods]
                         (map #(assoc % :sha sha) mods)))]
      (pom/spit-poms opts)
      (util/do-modules opts (fn [_] (mvn "deploy")))
      (mvn "deploy")

      ;; if :old-group-id is defined, create a new pom (in temp dir)
      ;; with :old-group-id (name, version same) and points to the
      ;; package under actual :group-id as a single dependency
      (when (:old-group-id opts)
        (util/with-temp-cwd
          (pom/spit-old-group-id-pom opts)
          (mvn "deploy")))

      (prepend-changelog-placeholders)
      (git/git! "add" "pom.xml")
      (util/do-modules opts (fn [_] (git/git! "add" "pom.xml")))
      (git/git! "add" "CHANGELOG.md")
      (git/git! "commit" "-m" "Update pom.xml and add CHANGELOG.md placeholders")
      (git/git! "push" "--tags")
      (git/git! "push")

      (github/create-release opts)
      (github/notify-prs-of-release opts)

      ;; Disable this for now, something changed on the server causing curl to
      ;; hang instead of exiting
      #_(trigger-cljdoc-build opts)
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
