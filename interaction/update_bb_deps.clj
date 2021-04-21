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

(update-artifact (shellutil/glob "../*/bb_deps.edn")
                 'lambdaisland/open-source
                 :sha
                 (git/current-sha))

(update-artifact (shellutil/glob "../**/deps.edn")
                 'lambdaisland/glogi
                 :mvn/version
                 "1.0.106")
