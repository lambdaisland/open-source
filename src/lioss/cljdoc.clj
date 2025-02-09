(ns lioss.cljdoc
  (:require
   [clojure.java.io :as io]
   [clojure.string :as str]
   [lioss.subshell :as subshell]
   [lioss.release :as release]
   [lioss.util :as util]))

(defn ingest
  "Run cljdoc in Docker to ingest the current version of this project."
  [{:keys [group-id name version] :as opts}]
  (release/do-install opts)

  (subshell/spawn "docker" "run" "--volume" (str (System/getProperty "user.home") "/.m2:/root/.m2")
                  "--volume" "/tmp/cljdoc:/app/data" "--entrypoint" "clojure"
                  "cljdoc/cljdoc" "-Sforce" "-M:cli" "ingest"
                  "--project" (str group-id "/" name) "--version" version))
