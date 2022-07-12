(ns lioss.util
  (:require [clojure.java.io :as io])
  (:import [java.io File]))

(defn delete-recursively
  "Delete a directory recursively.

  Also deletes if given just a file."
  [^java.io.File file]
  (when (.isDirectory file)
    (run! delete-recursively (.listFiles file)))
  (io/delete-file file))

(def ^:dynamic *cwd* (System/getProperty "user.dir"))

(defmacro with-cwd [cwd & body]
  `(let [prev# *cwd*
         cwd# (File. *cwd* ~cwd)]
     (binding [*cwd* cwd#]
       (try
         (System/setProperty "user.dir" (str cwd#))
         ~@body
         (finally
           (System/setProperty "user.dir" prev#))))))

(defmacro with-temp-cwd
  "Same as with-cwd except that it creates a temp dir
  in *cwd* and evals the body inside it.

  It cleans up the temp dir afterwards also removing
  any temp files created within it."
  [& body]
  `(let [cwd# ".temp"
         dir# (File. *cwd* cwd#)]
     (.mkdirs dir#)
     (with-cwd cwd# ~@body)
     (delete-recursively dir#)))

(defn slurp-cwd [f]
  (slurp (File. *cwd* f)))

(defn spit-cwd [f c]
  (spit (File. *cwd* f) c))

(defn read-deps []
  (read-string (slurp-cwd "deps.edn")))

(defn do-modules [opts f]
  (doseq [mod-opts (:modules opts)
          :when (not (false? (:release mod-opts)))]
    (with-cwd (str "modules/" (:name mod-opts))
      (f (merge opts mod-opts)))))

(defn fatal [& msg]
  (apply println "[\033[0;31mERROR\033[0m]" msg)
  (System/exit -1))
