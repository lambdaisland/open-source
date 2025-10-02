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
   :gh-actions "[![GitHub Actions](https://github.com/{{gh-project}}/actions/workflows/main.yml/badge.svg)](https://github.com/{{gh-project}}/actions/workflows/main.yml)"
   :circle-ci "[![CircleCI](https://circleci.com/gh/{{group-id}}/{{project}}.svg?style=svg)](https://circleci.com/gh/{{group-id}}/{{project}})"
   :cljdoc    "[![cljdoc badge](https://cljdoc.org/badge/{{group-id}}/{{project}})](https://cljdoc.org/d/{{group-id}}/{{project}})"
   :clojars   "[![Clojars Project](https://img.shields.io/clojars/v/{{group-id}}/{{project}}.svg)](https://clojars.org/{{group-id}}/{{project}})"))

(def defaults
  {:circle-ci (and (seq (filter #(re-find #"_test.clj(s|c)?" (str %))
                                (file-seq (io/file "test"))))
                   (.exists (io/file ".circleci")))
   :cljdoc true
   :clojars true
   :gh-actions (and (seq (filter #(re-find #"_test.clj(s|c)?" (str %))
                                 (file-seq (io/file "test"))))
                    (.exists (io/file ".github/workflows/main.yml")))})


(defn template [flags]
  (str/join " " (keep (fn [[k v]] (when (get flags k) v)) templates)))
