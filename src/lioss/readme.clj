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

(defn update-sections [blob section-map params]
  (let [lines (lines blob)]
    (loop [result []
           [line & lines] lines]
      (cond
        (not line)
        (str/join "\n" result)

        (section-start? line)
        (let [section (section-start? line)
              replacement (reduce-kv (fn [sec k v]
                                       (str/replace sec (str "{{" (name k) "}}") (str v)))
                                     (get section-map (keyword section))
                                     params)]
          (recur (conj result
                       (section-start section)
                       replacement
                       (section-end section))
                 (next (drop-while #(not (section-end? % section)) lines))))

        :else
        (recur (conj result line) lines)))))

(defn do-readme [params]
  (let [sections (section-map (slurp (io/resource "README_template.md")))
        sections (assoc sections :license (case (:license params)
                                            :mpl
                                            (:license-mpl sections)
                                            :epl
                                            (:license-epl sections)))
        this-year (+ 1900 (.getYear (java.util.Date.)))
        inception-year (:inception-year params)
        year-range (if (= this-year inception-year)
                     this-year
                     (str inception-year "-" this-year))
        params (assoc params
                      :project (:name params)
                      :year-range year-range
                      :license-name (case (:license params)
                                      :mpl
                                      "MPL 2.0"
                                      :epl
                                      "EPL 1.0"))]
    (spit "README.md"
          (update-sections
           (slurp "README.md")
           sections
           params))))
