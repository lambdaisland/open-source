(ns lioss.main
  (:require
   [clojure.java.io :as io]
   [clojure.java.shell :as sh]
   [clojure.pprint :as pprint]
   [clojure.string :as str]
   [lambdaisland.cli :as cli]
   [lambdaisland.launchpad :as launchpad]
   [lioss.cljdoc :as cljdoc]
   [lioss.gh-actions :as gh-actions]
   [lioss.git :as git]
   [lioss.hiccup :as hiccup]
   [lioss.pom :as pom]
   [lioss.readme :as readme]
   [lioss.release :as release]
   [lioss.util :as util]
   [lioss.version :as version]))

(defn inspect
  "Show expanded opts and exit"
  [opts]
  (pprint/pprint opts))

(defn launchpad
  "Launch a REPL with Launchpad"
  [_]
  (launchpad/main {:steps (into [(partial launchpad/ensure-java-version 17)] launchpad/default-steps)}) )

(def commands
  ["release"                     #'release/do-release
   "pom"                         #'pom/spit-poms
   "relocation-pom"              #'pom/spit-relocation-poms
   "install"                     #'release/do-install
   "print-versions"              #'release/print-versions
   "gh_actions_changelog_output" #'gh-actions/set-changelog-output
   "inspect"                     #'inspect
   "gen-readme"                  #'readme/do-gen
   "update-readme"               #'readme/do-update
   "bump-version"                #'version/bump-version!
   "launchpad"                   #'launchpad
   "ingest-docs"                 #'cljdoc/ingest])

(def init
  {:name           (git/project-name)
   :sha            (git/current-sha)
   :group-id       nil
   :gh-project     (str (git/org-name) "/" (git/project-name))
   :org-name       "Lambda Island"
   :org-url        "https://lambdaisland.com"
   :date           (str (java.time.LocalDate/now))
   :latest-version (or (git/last-released-version) "0.0.0")
   :authors        (when (.exists (io/file "AUTHORS"))
                     (str/split (str/trim (slurp "AUTHORS")) #"\R"))
   :paths          ["src"]})

(defn main [opts]
  (assert (:group-id opts) ":group-id should be set explicitly")
  (let [commands (into commands (:commands opts))
        opts     (merge init (util/read-deps) opts)
        opts     (-> opts
                     (update :modules #(for [{:keys [name] :as mod-opts} %]
                                         (util/with-cwd (str "modules/" name)
                                           (merge (dissoc opts :modules)
                                                  (util/read-deps)
                                                  mod-opts))))
                     (version/add-version-info))]

    (cli/dispatch*
     {:name "bin/proj"
      :init opts
      :commands commands}
     *command-line-args*)))
