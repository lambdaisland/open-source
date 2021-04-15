(ns lioss.shellutil
  (:require [clojure.java.io :as io]
            [lioss.util :as util])
  (:import [java.io File]))

(defn file [path]
  (io/file util/*cwd* path))

(defn- glob->regex
  "Takes a glob-format string and returns a regex."
  [s]
  (loop [stream s
         re ""
         curly-depth 0]
    (let [[c j] stream]
      (cond
        (nil? c) (re-pattern (str (if (= \. (first s)) "" "(?=[^\\.])") re))
        (= c \\) (recur (nnext stream) (str re c c) curly-depth)
        (= c \/) (recur (next stream) (str re (if (= \. j) c "/(?=[^\\.])"))
                        curly-depth)
        (= c \*) (recur (next stream) (str re "[^/]*") curly-depth)
        (= c \?) (recur (next stream) (str re "[^/]") curly-depth)
        (= c \{) (recur (next stream) (str re \() (inc curly-depth))
        (= c \}) (recur (next stream) (str re \)) (dec curly-depth))
        (and (= c \,) (< 0 curly-depth)) (recur (next stream) (str re \|)
                                                curly-depth)
        (#{\. \( \) \| \+ \^ \$ \@ \%} c) (recur (next stream) (str re \\ c)
                                                 curly-depth)
        :else (recur (next stream) (str re c) curly-depth)))))

;; compromise to aid in testing
(defn- get-root-file
  [root-name]
  (file (str root-name "/")))

(defn get-cwd-file
  []
  (io/file util/*cwd*))

(defn dir-files [dir]
  (.listFiles ^File dir))

(defn parent-file [dir]
  (.getParentFile ^File dir))

(defn filter-files
  "Filter list of files for names matching pattern re"
  [files re]
  (filter #(re-find re (.getName ^File %)) files))

(defn glob
  "Returns a seq of java.io.File instances that match the given glob pattern.
  Ignores dot files unless explicitly included.

  Examples: (glob \"*.{jpg,gif}\") (glob \".*\") (glob \"/usr/*/se*\")

  Based on
  https://github.com/jkk/clj-glob/blob/b1df67efb003f0e372c914346209d41c6df78e20/src/org/satta/glob.clj
  "
  [pattern]
  (let [[root & _ :as parts] (.split #"[\\/]" pattern)
        abs? (or (empty? root) ;unix
                 (= \: (second root))) ;windows
        start-dir (if abs? (get-root-file root) (get-cwd-file))
        patterns (if abs? (rest parts) parts)]
    (reduce
     (fn [files pattern]
       (cond
         (= "." pattern)
         (mapcat dir-files files)
         (= ".." pattern)
         (map parent-file files)
         :else
         (mapcat #(filter-files (dir-files %) (glob->regex pattern)) files)))
     [start-dir]
     patterns)))

(defn mkdir-p [dir]
  (.mkdirs (file dir)))
