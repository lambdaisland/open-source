(ns lioss.subshell
  (:require [clojure.string :as str]
            [clojure.java.io :as io]
            [lioss.util :as util]))

(defn process-builder [args]
  (doto (ProcessBuilder. args)
    (.inheritIO)))

(def windows? (str/starts-with? (System/getProperty "os.name") "Windows"))

(defn- cmd->str [args]
  (str/join " " (map #(if (str/includes? % " ") (pr-str %) %) args)))

(defn spawn
  "Like [[clojure.java.shell/sh]], but inherit IO stream from the parent process,
  and prints out the invocation."
  [& args]
  (let [[opts args] (if (map? (last args))
                      [(last args) (butlast args)]
                      [{} args])
        dir (:dir opts util/*cwd*)
        args (if windows? (cons "winpty" args) args)]
    (println "=>" (cmd->str args) (if dir (str "(in " dir ")") ""))
    (let [res (-> (process-builder args)
                  (cond-> dir
                    (.directory (io/file dir)))
                  .start
                  .waitFor)]
      (when (and (not= 0 res) (not (:continue-on-error? opts)))
        (util/fatal (:fail-message opts "command failed") res)))))
