(ns lioss.git
  (:require [clojure.java.shell :as sh]
            [clojure.string :as str]
            [lioss.subshell :as subshell]
            [lioss.util :as util]
            [clojure.java.io :as io]))

(defn git [& args]
  (str/trim (:out (apply sh/sh "git" args))))

(defn git!
  "Use this if the user should see what's happening"
  [& args]
  (apply subshell/spawn "git" args))

(defn commit-count []
  (git "rev-list" "--count" "HEAD"))

(defn current-branch []
  (git "rev-parse" "--abbrev-ref" "HEAD"))

(defn current-sha []
  (git "rev-parse" "HEAD"))

(defn repo-clean? []
  (str/blank? (git "status" "--porcelain")))

(defn clean! []
  (git "clean" "-xfd"))

(defn clone-with-cwd! [url cwd]
  (git! "clone" url :dir cwd))

(defn clone! [url]
  (git! "clone" url))

(defn version-string []
  (str
   (if (.exists (io/file ".VERSION_PREFIX"))
     (str/trim (slurp ".VERSION_PREFIX"))
     "0.0")
   "."
   (commit-count)))

(defn project-name []
  (if-let [repo (System/getenv "GITHUB_REPOSITORY")]
    (second (str/split repo #"/"))
    (let [url (git "remote" "get-url" "origin")]
      (second (re-find #"lambdaisland/([\.a-z0-9-]+?)(\.git)?$" url)))))

(defn assert-branch [branch]
  (let [b (current-branch)]
    (when-not (if (coll? branch)
                (some #{b} branch)
                (= b branch))
      (util/fatal "On branch" b ", must be on" branch))))

(defn assert-repo-clean []
  (when-not (repo-clean?)
    (util/fatal "Repo not clean." (git "status" "--short"))))

(defn version-vector [v]
  (let [v (first (str/split v #"\+"))]
    ;; if the segment starts with digits then parse those and compare them
    ;; numerically, else keep the segment and compare it as a string.
    (mapv #(if-let [num (re-find #"^\d+" %)]
             (Integer/parseInt num)
             %)
          (clojure.string/split v #"\."))))

(defn compare-versions [v1 v2]
  (let [v1 (version-vector v1)
        v2 (version-vector v2)
        significance (min (count v1) (count v2))]
    (compare (vec (take significance v1))
             (vec (take significance v2)))))

(defn version>=? [v1 v2]
  (if (and v1 v2)
    (>= (compare-versions v1 v2) 0)
    true))

(defn last-released-version []
  (->> (str/split (git "tag") #"\n")
       (filter #(#{\v} (first %)))
       (map #(subs % 1))
       (sort #(compare-versions %1 %2))
       last))
