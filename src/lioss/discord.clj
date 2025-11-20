(ns lioss.discord
  (:require
   [cheshire.core :as json]
   [lioss.config :as cfg]
   [org.httpkit.client :as http]))

(defn format-release [{:keys [group-id name version changelog]}]
  (str group-id "/" name " " version "\n\n" changelog))

(defn notify-release! [opts]
  (if-let [webhook-url (cfg/get :discord/releases-webhook)]
    (http/post
     webhook-url
     {:headers {"content-type" "application/json"}
      :body
      (json/encode {:content (format-release opts)})})
    (println "[WARN] Configure :discord/releases-webhook in ~/.config/lioss.edn to get Discord notifications")))
