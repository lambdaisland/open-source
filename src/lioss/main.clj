(ns lioss.main
  (:require [clojure.java.io :as io]
            [clojure.java.shell :as sh]
            [clojure.pprint :as pprint]
            [clojure.string :as str]
            [lioss.gh-actions :as gh-actions]
            [lioss.git :as git]
            [lioss.hiccup :as hiccup]
            [lioss.pom :as pom]
            [lioss.readme :as readme]
            [lioss.release :as release]
            [lioss.util :as util]))

(defn print-help [prefix commands]
  (println "Usage:" prefix "[COMMAND] [COMMAND_ARGS...]")
  (println)
  (doseq [[cmd {:keys [description]}] (partition 2 commands)]
    (println (format "  %-35s%s" cmd description))))

(declare commands)

(defn do-help [opts]
  (print-help "bin/proj"
              (concat (:commands opts) commands)))

(def commands
  ["release"
   {:description "Release a new version to clojars"
    :command release/do-release}

   "pom"
   {:description "Generate pom files"
    :command pom/spit-poms}

   "relocation-pom"
   {:description "Generate pom files to relocate artifacts to a new groupId"
    :command pom/spit-relocation-poms}

   "install"
   {:description "Build and install jar(s) locally"
    :command release/do-install}

   "print-versions"
   {:description "Print deps.edn / lein coordinates"
    :command release/print-versions}

   "gh_actions_changelog_output"
   {:description "Print the last stanza of the changelog in a format that GH actions understands"
    :command gh-actions/set-changelog-output}

   "help"
   {:description "Show this help information"
    :command do-help}

   "inspect"
   {:description "Show expanded opts and exit"
    :command clojure.pprint/pprint}

   "gen-readme"
   {:description "Generate README based on a template and fill in project variables"
    :command readme/do-gen}

   "update-readme"
   {:description "Update sections in README.md"
    :command readme/do-update}])

(def defaults
  {:name           (git/project-name)
   :version        (git/version-string)
   :sha            (git/current-sha)
   :group-id       "com.lambdaisland"
   :gh-project     (str "lambdaisland/" (git/project-name))
   :org-name       "Lambda Island"
   :org-url        "https://lambdaisland.com"
   :date           (str (java.time.LocalDate/now))
   :latest-version (or (git/last-released-version) "0.0.0")})

(defn module-versions [{:keys [name group-id version modules]}]
  (into {(symbol group-id name) version}
        (map (fn [{:keys [name group-id version]}]
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

(defn main [opts]
  (let [commands (concat (:commands opts) commands)
        opts     (merge defaults (util/read-deps) opts)
        opts     (-> opts
                     (update :modules #(for [{:keys [name] :as mod-opts} %]
                                         (util/with-cwd (str "modules/" name)
                                           (merge opts mod-opts)))))
        mod-vers (module-versions opts)
        opts     (-> opts
                     (assoc :module-versions mod-vers)
                     (override-versions mod-vers)
                     (update :modules
                             (fn [mods]
                               (map #(override-versions % mod-vers)
                                    mods))))]

    (if-let [{:keys [command]} (get (apply hash-map commands)
                                    (first *command-line-args*))]
      (command (assoc opts :argv (next *command-line-args*)))
      (do-help opts))))
