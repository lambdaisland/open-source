(ns lioss.gh-actions
  (:require [clojure.string :as str]))

;; https://github.community/t5/GitHub-Actions/set-output-Truncates-Multiline-Strings/m-p/38372#M3322
(defn multiline-escape [s]
  (-> s
      (str/replace #"%" "%25")
      (str/replace #"\n" "%0A")
      (str/replace #"\r" "%0D")))

(defn changelog-stanza []
  ;; All fair and well but flexmark doesn't work on babashka...
  #_(-> (with-out-str
          (let [{:keys [added fixed changed]}
                (first (remove (comp #{"Unreleased"} :version-id)
                               (janus/parse (slurp "CHANGELOG.md"))))]
            (when (seq added)
              (println (str "### Added"))
              (run! #(print "- " %) added))
            (when (seq fixed)
              (println (str "### Fixed"))
              (run! #(print "- " %) fixed))
            (when (seq changed)
              (println (str "### Changed"))
              (run! #(print "- " %) changed))
            (println)))
        )

  (-> "CHANGELOG.md"
      slurp
      (str/split #"\n")
      (->> (drop-while #(not (re-find #"^# \d" %)))
           next
           (take-while #(not (re-find #"^# \d" %)))
           (remove str/blank?)
           (str/join "\n"))
      multiline-escape))

(defn set-changelog-output [opts]
  (println (str "::set-output name=changelog::" (changelog-stanza))))
