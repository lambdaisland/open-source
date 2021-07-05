(ns lioss.repl
   (:require [lioss.github :as github]) 
  )


(defn get-repository-issues
  "Fetch all issues in a Lambda Island Open Source repository."
  [repository]

  (github/get-all-repository-issues repository (github/get-token)))


(defn get-all-clojars-repository-issues
  "Fetch all issues in a Lambda Island Open Source repository, 
  asking for a token."
  []
  (->> (github/get-clojars-lioss-repositories (github/get-token))
       (pmap #(get % "name"))
       (pmap get-repository-issues)
       (apply concat)))
