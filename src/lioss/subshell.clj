(ns lioss.subshell
  (:require [clojure.string :as str]
            [clojure.java.io :as io]
            [lioss.util :as util]))

(defn process-builder [args]
  (doto (ProcessBuilder. args)
    (.redirectInput java.lang.ProcessBuilder$Redirect/INHERIT)
    (.redirectError java.lang.ProcessBuilder$Redirect/INHERIT)
    (.redirectOutput java.lang.ProcessBuilder$Redirect/INHERIT)))

(defn spawn
  "Like [[clojure.java.shell/sh]], but inherit IO stream from the parent process,
  and prints out the invocation."
  [& args]
  (let [[opts args] (if (map? (last args))
                      [(last args) (butlast args)]
                      [{} args])
        dir (:dir opts util/*cwd*)]
    (println "=>" (str/join " " args) (if dir (str "(in " dir ")") ""))
    (-> (process-builder args)
        (cond-> dir
          (.directory (io/file dir)))
        .start
        .waitFor)))
