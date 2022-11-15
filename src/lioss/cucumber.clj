(ns lioss.cucumber
  (:require [lambdaisland.cucumber.jvm :as jvm]
            [lambdaisland.cucumber.output :as cucumber-output]
            [lambdaisland.cucumber.gherkin :as gherkin]
            [clojure.string :as str]
            [clojure.java.io :as io])
  )

(defn list-cucumber-docs
  "Lists any cucumber docs.
  
  Does not examine the test configuration, just looks for .feature files."
  [repository-path]
  (->> repository-path
                 io/file
                 file-seq
                 (map str)
                 (filter #(str/ends-with? % ".feature"))))

(defn has-cucumber-docs? 
  [repository-path]
  (boolean (and (.exists (io/file repository-path)) (take 1 (list-cucumber-docs repository-path)))))

(defn generate-docs
  "Generates Cucumber documentation for the repository"
  ([]
   (generate-docs "."))
  ([repo-path]
   (doseq [f (list-cucumber-docs repo-path)]
     (with-open [out (-> f
                         (str/replace "test/features" "doc")
                         (str/replace ".feature" ".md")
                         io/writer)]
       (binding [*out* out]
         (->> f
              jvm/parse
              gherkin/gherkin->edn
              cucumber-output/print-markdown))))))


(generate-docs "/home/alys/repos/lambdaisland/kaocha/")


