
(ns lioss.github
  (:require [org.httpkit.client :as http]
            [cheshire.core :as json]
            [lioss.git :as git]
            [clojure.string :as string])
  (:import [java.time LocalDateTime Instant ]
           [java.time.temporal ChronoUnit])
  )


(def highlighted #{"kaocha" "deep-diff2" "regal" "uri" "glogi" "ansi" "chui"
                   "funnel" "edn-lines" "fetch" "data-printers" "daedalus"
                   "cljbox2d" "spec-monstah-malli" "trikl" "zipper-viz"})

(defn get-next-url
  "Gets the next URL from the Link header."
  [header]
  (first (for [header-line (string/split header #",")
          :let [[url rel] (string/split header-line #";")
                string (second (re-matches #"<(.*)>" (string/trim url)))] 
          :when (string/includes? rel "next")]
    string)))

(defn get-all-lioss-repos []
  (loop [url "https://api.github.com/orgs/lambdaisland/repos"
         repos []]
    (let [response @(http/get url)
          body (json/decode (:body response))
          new-repos (into repos body)]
      (if-let [next-url  (get-next-url (get-in response [:headers :link]))]
        (recur next-url new-repos)
        new-repos))))


(defn get-top-lioss-repos []
  (filter  #(contains? highlighted  (get %  "name" ))
    (get-all-lioss-repos)))
(

  
  

(filter #(> ()) (map #(LocalDateTime/parse (apply str (butlast (get % "updated_at")))) l))
  )


(defn get-recent-lioss-repos []
  (let [year-ago (.minus (Instant/now) 365 ChronoUnit/DAYS) ]
    (filter 
      #(= -1 (compare year-ago (Instant/parse (get % "updated_at")) ))
            (get-all-lioss-repos) )))





