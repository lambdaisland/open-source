(ns lioss.badges
  "Code for generating README badges. The CircleCI badge will only be shown if
  there is a .circleci config directory present, and there are actual test files
  under `test/`. Other badges are on by default but can be disabled in
  `bin/proj`. This can also be used to force a badge to be present (e.g. when
  the test setup isn't detected).

  ```
  (lioss/main {:badges {:cljdoc false}})
  ```
  "
  (:require [clojure.string :as str]
            [clojure.java.io :as io]))

(def templates
  (array-map
   :circle-ci "[![CircleCI](https://circleci.com/gh/lambdaisland/{{project}}.svg?style=svg)](https://circleci.com/gh/lambdaisland/{{project}})"
   :cljdoc    "[![cljdoc badge](https://cljdoc.org/badge/lambdaisland/{{project}})](https://cljdoc.org/d/lambdaisland/{{project}})"
   :clojars   "[![Clojars Project](https://img.shields.io/clojars/v/lambdaisland/{{project}}.svg)](https://clojars.org/lambdaisland/{{project}})"))

(def defaults
  {:circle-ci (and (seq (filter #(re-find #"_test.clj(s|c)?" (str %))
                                (file-seq (io/file "test"))))
                   (.exists (io/file ".circleci")))
   :cljdoc true
   :clojars true})

(defn template [flags]
  (str/join " " (keep (fn [[k v]] (when (get flags k) v)) templates)))
