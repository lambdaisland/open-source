(ns lioss.cljdoc

(:require [clojure.java.io :as io]
          [clojure.string :as str]
          [lioss.subshell :as subshell]
          [lioss.release :as release]
          [lioss.util :as util]))


(defn ingest
  "Ingest"
  [opts]
  (release/do-install opts)

  (subshell/spawn "docker" "run" "--volume" (str (System/getProperty "user.home")   "/.m2:/root/.m2") "--volume" "/tmp/cljdoc:/app/data" "--entrypoint" "clojure" "cljdoc/cljdoc" "-Sforce" "-M:cli" "ingest" "--project" "lambdaisland/kaocha-cljs2" "--version" "0.1.67" )
  )
