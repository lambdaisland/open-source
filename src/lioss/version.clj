(ns lioss.version
  "Logic related to getting, bumping, keeping in sync, the version of the
  library."
  (:require [clojure.java.io :as io]
            [clojure.string :as str]
            [lambdaisland.regal :as regal]
            [lioss.git :as git]))

(defn module-versions
  "For all modules, including the main/parent module, create a map with the right
  version (symbol -> version)"
  [{:keys [name group-id version modules]}]
  (into {(symbol group-id name) version}
        (map (fn [{:keys [name group-id] :as module}]
               [(symbol group-id name) (or (:version module)
                                           version)]))
        modules))

(defn override-deps-versions
  "Update the versions of artifacts in the `:deps`, we read these from `deps.edn`
  and have them in the options map which we pass around so that they can be
  added to the pom.xml"
  [opts versions]
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

;; TODO: gracefully migrate from .VERSION_PREFIX to .config/version.edn

(defn read-version-string
  "Get the version string based on .VERSION_PREFIX and number of git commits"
  [{:keys [version-qualifier]}]
  (str
   (if (.exists (io/file ".VERSION_PREFIX"))
     (str/trim (slurp ".VERSION_PREFIX"))
     "0.0")
   "."
   (git/commit-count)
   (when version-qualifier
     (str "-" version-qualifier))))

(defn bump-version!
  "Bump minor version

  We bump the minor version on every release, the teeny version is the number of
  git commits and is handled in [[read-version-string]]."
  []
  (let [version (if (.exists (io/file ".VERSION_PREFIX"))
                  (str/trim (slurp ".VERSION_PREFIX"))
                  "0.0")]
    (when-let [[_ major minor] (re-find #"^(\d+)\.(\d+)$" version)]
      (spit ".VERSION_PREFIX" (str major "." (inc (Long/parseLong minor)))))))

(defn add-version-info
  "Add version info to the opts map, needs to be called again if the version
  changes."
  [opts]
  (let [opts     (assoc opts :version (read-version-string opts))
        mod-vers (module-versions opts)]
    (-> opts
        (assoc :module-versions mod-vers)
        (override-deps-versions mod-vers)
        (update :modules
                (fn [mods]
                  (map #(override-deps-versions % mod-vers)
                       mods))))))

(defn update-versions-in
  "Given a map of artifact name to version string, update matching version
  coordinates in the README."
  [file versions]
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
