(ns lioss.config
  (:require
   [lambdaisland.config :as config]))

(def cfg (config/create {:prefix "lioss"}))

(defn get [k] (config/get cfg k))
