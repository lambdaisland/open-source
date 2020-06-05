(ns lioss.releases
  (:gen-class)
  (:require [lambdaisland.janus :as janus]
            [clojure.string :as str]
            [clojure.java.io :as io]))

(defn logfiles []
  (->> (io/file "..")
       file-seq
       (filter #(str/ends-with? (str %) "CHANGELOG.md"))))

#_(janus/parse (slurp (first (logfiles))))
(defn -main [& _]
  (spit "RELEASES.md"
        (with-out-str
          (doseq [{:keys [project version-id sha date added fixed changed]}
                  (->> (for [logfile (logfiles)
                             section (janus/parse (slurp logfile))
                             :when (:date section)
                             :when (not (#{"Unreleased" "Changelog"} (:version-id section)))]
                         (assoc section :project (-> logfile
                                                     str
                                                     (str/replace "../" "")
                                                     (str/replace #"/.*" ""))))
                       (sort-by :date)
                       reverse
                       )]
            (println (str "# [" (str/capitalize project) "](https://github.com/lambadisland/" project ") "  version-id " (" date (when sha (str " / " sha)) ")"))
            (println)
            (when (seq added)
              #_(println (str "## Added"))
              #_(println)
              (run! #(print "- " %) added))
            (when (seq fixed)
              #_(println (str "## Fixed"))
              #_(println)
              (run! #(print "- " %) fixed))
            (when (seq changed)
              #_(println (str "## Changed"))
              (run! #(print "- " %) changed))
            (println)))))

(comment

  (for [logfile (logfiles)
        section (janus/parse (slurp logfile))
        :when (#{"Unreleased"} (:version-id section))
        :let [project (-> logfile str (str/replace "../" "") (str/replace #"/.*" ""))
              {:keys [version-id sha date added fixed changed]} section]
        :when (seq (concat added fixed changed))]
    [project added fixed changed])

  )
