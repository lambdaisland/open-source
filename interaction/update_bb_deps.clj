(ns interaction.update-bb-deps
  (:require [lioss.git :as git]
            [lioss.shellutil :as shellutil]
            [rewrite-clj.zip :as rzip]))

(doseq [path (shellutil/glob "../*/bb_deps.edn")
        :let [loc (rzip/of-file path)]]
  (some-> loc
          (rzip/find-value rzip/next 'lambdaisland/open-source)
          rzip/right
          (rzip/find-value rzip/next :sha)
          rzip/right
          (rzip/replace (git/current-sha))
          rzip/root-string
          (->> (spit path))))
