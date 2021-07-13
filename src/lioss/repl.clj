(ns lioss.repl
  (:require [lioss.github :as github]
            [lioss.git :as git]) )

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

(defn run-in-repos [& cmd]

  (doseq [dir  (->> (github/get-clojars-lioss-repositories (github/get-token))
                    (map #(get % "name"))
                    (map #(str "../" %)))]
    (prn (concat cmd [{:dir dir :continue-on-error? true}]))
    (let [full-cmd (concat cmd [{:dir dir :continue-on-error? true}])]
      (apply git/git! full-cmd ))))

(comment (run-in-repos  "version" ))

