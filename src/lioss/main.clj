(ns lioss.main
  (:require [clojure.java.io :as io]
            [clojure.java.shell :as sh]
            [clojure.string :as str]
            [lioss.hiccup :as hiccup]
            [lioss.git :as git]
            [lioss.release :as release]
            [lioss.pom :as pom]
            [lioss.util :as util]))

(defn print-help [prefix commands]
  (println "Usage:" prefix "[COMMAND] [COMMAND_ARGS...]")
  (println)
  (doseq [[cmd {:keys [description]}] (partition 2 commands)]
    (println (format "  %-15s%s" cmd description))))

(def commands
  ["release"
   {:description "Release a new version to clojars"
    :command release/do-release}

   "pom"
   {:description "Generate pom files"
    :command pom/spit-poms}

   "help"
   {:description "Show this help information"
    :command (fn [_] (print-help "bin/proj" commands))}])

(def defaults
  {:name       (git/project-name)
   :version    (git/version-string)
   :sha        (git/current-sha)
   :group-id   "lambdaisland"
   :gh-project (str "lambdaisland/" (git/project-name))
   :org-name   "Lambda Island"
   :org-url    "https://lambdaisland.com"
   :date       (str (java.time.LocalDate/now))})

(defn main [opts]
  (let [opts (update (merge defaults (util/read-deps) opts)
                     :modules
                     (fn [mods]
                       (into {}
                             (map (fn [[mod mod-opts]]
                                    (util/with-cwd (str "modules/" (name mod))
                                      [mod (merge defaults
                                                  (util/read-deps)
                                                  opts
                                                  {:name (name mod)}
                                                  mod-opts)])))
                             mods)))]
    (if-let [{:keys [command]} (get (apply hash-map commands) (first *command-line-args*))]
      (command opts #_(next *command-line-args*))
      ((-> (last commands)
           :command) nil))))
