(ns lioss.readme
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(defn section-start? [line]
  (second (re-find #"<!--\s*([-\d\w]+)\s*-->" line)))

(defn section-end? [line section]
  (= section
     (second (re-find #"<!--\s*/([-\d\w]+)\s*-->" line))))

(defn section-start [section]
  (str "<!-- " section " -->"))

(defn section-end [section]
  (str "<!-- /" section " -->"))

(defn lines [blob]
  (str/split blob #"\R"))

(defn section-map [blob]
  (let [lines (lines blob)]
    (loop [section nil
           sections {}
           [line & lines] lines]
      (cond
        (not line)
        (into {}
              (map (juxt key (comp #(str/join "\n" %) val)))
              sections)

        (section-start? line)
        (recur (section-start? line) sections lines)

        (section-end? line section)
        (recur nil sections lines)

        section
        (recur section
               (update sections (keyword section) (fnil conj []) line)
               lines)

        :else
        (recur nil sections lines)))))

(defn fill-params [s params]
  (reduce-kv (fn [sec k v]
               (str/replace sec (str "{{" (name k) "}}") (str v)))
             s
             params))

(defn update-sections [blob section-map params]
  (let [lines (lines blob)]
    (loop [result []
           [line & lines] lines]
      (cond
        (not line)
        (str/join "\n" result)

        (section-start? line)
        (let [section (section-start? line)
              template (get section-map (keyword section) "")
              replacement (fill-params template params)]
          (if (seq template)
            (recur (conj result
                         (section-start section)
                         replacement
                         (section-end section))
                   (next (drop-while #(not (section-end? % section)) lines)))
            (recur (conj result line) lines)))

        :else
        (recur (conj result line) lines)))))

(defn extra-params [params]
  (let [this-year (+ 1900 (.getYear (java.util.Date.)))
        inception-year (:inception-year params)
        year-range (if (= this-year inception-year)
                     this-year
                     (str inception-year "-" this-year))]
    (assoc params
           :project (:name params)
           :year-range year-range
           :license-name (case (:license params)
                           :mpl
                           "MPL 2.0"
                           :epl
                           "EPL 1.0"))))

(defn do-update [params]
  (let [sections (section-map (slurp (io/resource "README_sections.md")))
        sections (assoc sections :license (case (:license params)
                                            :mpl
                                            (:license-mpl sections)
                                            :epl
                                            (:license-epl sections)))
        params (extra-params params)]
    (spit "README.md"
          (update-sections
           (slurp "README.md")
           sections
           params))))

(defn do-gen [params]
  (when (.exists (io/file "README.md"))
    (println "README.md exists, overwrite? [y/n]")
    (when (not= "y" (doto (read-line) prn))
      (println "abort")
      (System/exit 1)))
  (spit "README.md" (fill-params (slurp (io/resource "README_template.md")) (extra-params params)))
  (do-update params))
