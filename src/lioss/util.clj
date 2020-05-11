(ns lioss.util
  (:import [java.io File]))

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

(defn slurp-cwd [f]
  (slurp (File. *cwd* f)))

(defn spit-cwd [f c]
  (spit (File. *cwd* f) c))

(defn read-deps []
  (read-string (slurp-cwd "deps.edn")))

(defn do-modules [opts f]
  (doseq [[mod mod-opts] (:modules opts)
          :when (not (false? (:release mod-opts)))]
    (with-cwd (str "modules/" (name mod))
      (f (merge (assoc opts :name (name mod)) mod-opts)))))

(defn fatal [& msg]
  (apply println "[\033[0;31mERROR\033[0m]" msg)
  (System/exit -1))
