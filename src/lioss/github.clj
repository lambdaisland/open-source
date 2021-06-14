
(ns lioss.github
  (:require [org.httpkit.client :as http]
            [cheshire.core :as json]
            [lioss.git :as git]
            [clojure.string :as string])
  (:import [java.time LocalDateTime Instant ]
           [java.time.temporal ChronoUnit])
  )


(def highlighted 
 "Repositories that we have highlighted in the README of this repository." 
  #{"kaocha" "deep-diff2" "regal" "uri" "glogi" "ansi" "chui"
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

(defn get-all-lioss-repositories
  "Fetch every Lambda Island Open Source repository."
  []
  (loop [url "https://api.github.com/orgs/lambdaisland/repos"
         repositories []]
    (let [response @(http/get url)
          body (json/decode (:body response))
          new-repositories (into repositories body)]
      (if-let [next-url  (get-next-url (get-in response [:headers :link]))]
        (recur next-url new-repositories)
        new-repositories))))


(defn get-top-lioss-repositories 
  "Fetches only the Lambda Island Open Source repositories featured in our README."
  []
  (filter  #(contains? highlighted  (get %  "name" ))
    (get-all-lioss-repositories)))
(

  
  

(filter #(> ()) (map #(LocalDateTime/parse (apply str (butlast (get % "updated_at")))) l))
  )


(defn get-recent-lioss-repositories
  "Gets Lambda Island Open Source repositories modified after a specific date.
  
  If no date is specified, assumes a year ago."
  ([]
   (let [year-ago (.minus (Instant/now) 365 ChronoUnit/DAYS) ]))
  ([start-date]
   (filter 
     #(= -1 (compare start-date (Instant/parse (get % "updated_at")) ))
     (get-all-lioss-repositories)))) 

