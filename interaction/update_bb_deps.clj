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

(update-artifact (shellutil/glob "../*/bb_deps.edn")
                 'lambdaisland/open-source
                 :sha
                 (git/current-sha))

(update-artifact (shellutil/glob "../**/deps.edn")
                 'lambdaisland/glogi
                 :mvn/version
                 "1.0.106")

(rename-artifact (shellutil/glob "../**/deps.edn")
                 'lambdaisland/glogi
                 'com.lambdaisland/glogi)

(def renames
  '{lambdaisland/glogi com.lambdaisland/glogi
    lambdaisland/funnel-client com.lambdaisland/funnel-client})

(def versions
  '{com.lambdaisland/glogi ""})

(doseq [[from to] renames]
  (rename-artifact (shellutil/glob "../**/deps.edn") from to))
(doseq [[from to] versions]
  (update-rename-artifact (shellutil/glob "../**/deps.edn") from :mvn/version to))
