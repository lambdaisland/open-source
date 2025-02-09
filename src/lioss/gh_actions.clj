(ns lioss.gh-actions
  (:require [clojure.string :as str]))

;; https://github.community/t5/GitHub-Actions/set-output-Truncates-Multiline-Strings/m-p/38372#M3322
(defn multiline-escape [s]
  (-> s
      (str/replace #"%" "%25")
      (str/replace #"\n" "%0A")
      (str/replace #"\r" "%0D")))

(defn changelog-stanza []
  (-> "CHANGELOG.md"
      slurp
      (str/split #"\n")
      (->> (drop-while #(not (re-find #"^# \d" %)))
           next
           (take-while #(not (re-find #"^# \d" %)))
           (remove str/blank?)
           (str/join "\n"))
      multiline-escape))

(defn set-changelog-output
  "Print the last stanza of the changelog in a format that GH actions understands"
  [opts]
  (println (str "::set-output name=changelog::" (changelog-stanza))))
