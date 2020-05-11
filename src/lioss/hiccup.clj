(ns lioss.hiccup
  (:require [clojure.string :as str]))

(defn split-tag [tag]
  (let [tag (name tag)
        parts (str/split tag #"\.")]
    [(first parts)
     (rest parts)]))

(defn split-el [[tag & tail]]
  (let [[tag kls] (split-tag tag)]
    [tag
     (cond-> (if (map? (first tail))
               (first tail)
               {})
       (seq kls)
       (update :class str (str/join " " kls)))
     (filter
      some?
      (if (map? (first tail))
        (next tail)
        tail))]))

(defn escape-attr [a]
  (-> a
      (str/replace #"&" "&amp;")
      (str/replace #"'" "&#x27;")
      (str/replace #"\"" "&quot;")))

(defn render-attrs [m]
  (->> m
       (map (fn [[k v]]
              (format " %s=\"%s\"" (name k) (escape-attr v))))
       (str/join "")))

(def ^:dynamic *nesting* 0)

(declare h)

(defn h* [hiccup]
  (binding [*nesting* (inc *nesting*)]
    (let [els (h hiccup)]
      (if (seq? els)
        els
        (list els)))))

(defn h [hiccup]
  (cond
    (string? hiccup)
    hiccup

    (vector? hiccup)
    (let [[tag attrs children] (split-el hiccup)]
      (if (or (empty? children)
              (and (= 1 (count children))
                   (string? (first children))))
        (format (str "\n%s"
                     "<%s%s>"
                     "%s"
                     "</%s>")
                (apply str (repeat *nesting* "  "))
                tag (render-attrs attrs)
                (apply str (mapcat h* children))
                tag)
        (format (str "\n%s"
                     "<%s%s>"
                     "%s"
                     "\n%s"
                     "</%s>")
                (apply str (repeat *nesting* "  "))
                tag (render-attrs attrs)
                (apply str (mapcat h* children))
                (apply str (repeat *nesting* "  "))
                tag)))

    (seq? hiccup)
    (apply str (mapcat h* hiccup))

    :else
    (h (str hiccup))))
