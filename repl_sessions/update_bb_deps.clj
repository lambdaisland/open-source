(ns interaction.update-bb-deps
  (:require [lioss.git :as git]
            [lioss.shellutil :as shellutil]
            [rewrite-clj.zip :as rzip]))

(defn update-artifact [deps-files artifact coordinate target]
  (doseq [path deps-files
          :let [loc (rzip/of-file path)]]
    (let [loc (some-> loc
                      (rzip/find-value rzip/next artifact)
                      rzip/right
                      (rzip/find-value rzip/next coordinate)
                      rzip/right)]
      (when (and loc (not= (rzip/sexpr loc) target))
        (println (str path))
        (some-> loc
                (rzip/replace target)
                rzip/root-string
                (->> (spit path)))))))

(defn rename-artifact [deps-files artifact target]
  (doseq [path deps-files
          :let [loc (rzip/of-file path)]]
    (let [loc (some-> loc
                      (rzip/find-value rzip/next artifact))]
      (when (and loc (not= (rzip/sexpr loc) target))
        (println (str path))
        (some-> loc
                (rzip/replace target)
                rzip/root-string
                (->> (spit path)))))))

(comment
  (update-artifact (shellutil/glob "../*/bb_deps.edn")
                   'lambdaisland/open-source
                   :sha
                   (git/current-sha))
  (update-artifact (shellutil/glob "../*/bb.edn")
                   'lambdaisland/open-source
                   :sha
                   (git/current-sha)))

(def renames
  '{lambdaisland/glogi com.lambdaisland/glogi
    lambdaisland/funnel-client com.lambdaisland/funnel-client
    lambdaisland/kaocha-cljs com.lambdaisland/kaocha-cljs
    lambdaisland/daedalus com.lambdaisland/daedalus})

(def versions
  '{com.lambdaisland/glogi "1.0.128"
    com.lambdaisland/kaocha-cljs "1.0.113"
    com.lambdaisland/daedalus "0.0.35"})

(comment
  (let [deps-edn-files (mapcat shellutil/glob ["/home/arne/ITRevolution/does/**/{deps,bb}.edn"
                                               "/home/arne/Eleven/**/{deps,bb}.edn"
                                               "/home/arne/ARS/**/{deps,bb}.edn"
                                               "/home/arne/LambdaIsland/**/{deps,bb}.edn"
                                               "../**/{deps,bb}.edn"
                                               ])]
    (println "renaming")
    (doseq [[from to] renames]
      (rename-artifact deps-edn-files from to))

    (println "updating")
    (doseq [[from to] versions]
      (update-artifact deps-edn-files from :mvn/version to))))
