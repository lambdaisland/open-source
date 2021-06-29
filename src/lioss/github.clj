(ns lioss.github
  (:require [org.httpkit.client :as http]
            [cheshire.core :as json]
            [lioss.git :as git]
            [clojure.java.shell  :as shell]
            [clojure.string :as string]) 
  (:import [java.time LocalDateTime Instant]
           [java.time.temporal ChronoUnit ChronoField]))

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

(comment 
(rate-limit-reached? @(http/get "https://api.github.com/orgs/lambdaisland/repos")))

(defn rate-limit-reached?
  [response]
  (-> response
      (get-in [:headers :x-ratelimit-remaining])
      Integer/parseInt
      zero?))


(defn get-all-lioss-repositories
  "Fetch every Lambda Island Open Source repository."
  [& token]
  (loop [url "https://api.github.com/orgs/lambdaisland/repos"
         repositories []]
    (let [headers (when-not (nil? token) 
                    {"Authorization" (str "token " (get-token))})
          response @(http/get url headers)
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

(defn get-recent-lioss-repositories
  "Gets Lambda Island Open Source repositories modified after a specific date.

  If no date is specified, assumes 365 days ago."
  ([]
   (let [year-ago (.minus (Instant/now) 365 ChronoUnit/DAYS) ]))
  ([start-date]
   (filter
     #(= -1 (compare start-date (Instant/parse (get % "updated_at")) ))
     (get-all-lioss-repositories))))

(defn decode-base64 [s]
  (:out (shell/sh "base64" "-d" :in s)))

(defn get-file
  "Gets a file from the respository"
  [repository path request-opts]
  (-> (get  repository "contents_url")
      (string/replace "{+path}" path)
      (http/get request-opts)
      deref
      :body
      json/decode
      (get "content")
      decode-base64))

(def get-token
  (memoize (fn []
             (println "GitHub token needed for this operation.")
             (println "You can create a token by visiting https://github.com/settings/tokens.")
             (print "Token: ")
             (read-line))))

(defn get-clojars-lioss-repositories
  "Gets Lambda Island Open Source repositories with a Clojars badge.

  This is a pretty accurate way of finding actual libraries or applications,
  rather than repositories that are merely for demonstration purposes.

  Because it does a signficant number of requests, it requires authorization."
  [token]
  (let [headers {"Authorization" (str "token " token)} ]
    (filter #(string/includes? (get-file %  "README.md" {:headers headers})
                               "img.shields.io/clojars")
            (get-all-lioss-repositories))))

(defn clone-repositories [repositories dir]
  (doseq
    [url  (map #(get % "clone_url") repositories)]
    (try
      (git/clone-with-cwd! url dir )
      (catch Exception _e
        (println _e)))))

(defn get-repository-issues [repository]
  (let [url (format "https://api.github.com/repos/lambdaisland/%s/issues" repository)]
    (-> (http/get url)
        deref
        :body
        json/decode)))

(defn get-all-repository-issues
  "Fetch all issues in a Lambda Island Open Source repository."
  [repository token]
  (loop [url (format "https://api.github.com/repos/lambdaisland/%s/issues" repository)
         issues []]
    (let [headers {"Authorization" (str "token " token)}
          response @(http/get url {:headers headers})
          body (json/decode (:body response))
          new-issues (into issues body)]
      (if-let [next-url (some-> response
                                (get-in [:headers :link])
                                get-next-url)]
        (recur next-url new-issues)
        new-issues))))

(comment (->> (get-all-repository-issues "kaocha")
              (sort-by #(get % "updated_at"))
              reverse
              ;; (map #(get % "title"))
              (map (fn [{:strs [title updated_at] }] [title updated_at] ))))

(comment (def issues 
  (->> (map #(get % "name") (get-clojars-lioss-repositories (get-token)))
       (mapcat #(do (prn %) (get-all-repository-issues %) ) )
       (sort-by #(get % "updated_at"))
       reverse
       ;; (map #(get % "title"))
       (map (fn [{:strs [title updated_at] }] [title updated_at] )))))

(comment (clone-repositories (get-clojars-lioss-repositories) ".."))
