(ns lioss.release-management
  (:require [clojure.java.io :as io]
            [clojure.java.shell :as sh]
            [clojure.string :as str]
            [lioss.hiccup :as hiccup]))

(defn version-string []
  (str
   (if (.exists (io/file ".VERSION_PREFIX"))
     (str/trim (slurp ".VERSION_PREFIX"))
     "0.0")
   "."
   (str/trim (:out (sh/sh "git" "rev-list" "--count" "HEAD")))))

(defn project-name []
  (let [url (:out (sh/sh "git" "remote" "get-url" "origin"))]
    (second (re-find #"lambdaisland/([\.a-z0-9-]+)\.git" url))))

(defn gen-pom [opts]
  (let [proj-name (:name opts (project-name))
        gh-project (:gh-project opts (str "lambdaisland/" proj-name))
        url (:url opts (str "https://github.com/" gh-project))]
    (str
     "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
     (hiccup/h
      [:project {:xmlns "http://maven.apache.org/POM/4.0.0",
                 :xmlns:xsi "http://www.w3.org/2001/XMLSchema-instance",
                 :xsi:schemalocation
                 "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"}
       [:modelVersion "4.0.0"]
       [:groupId (:group-id opts "lambdaisland")]
       [:artifactId proj-name]
       [:version (:version opts (version-string))]
       [:name proj-name]
       [:description (:description opts)]
       [:url url]
       [:inceptionYear (:inception-year opts)]
       [:organization
        [:name "Lambda Island"]
        [:url "https://lambdaisland.com"]]
       [:licenses
        (case (:license opts)
          :epl
          [:license
           [:name "Eclipse Public License 1.0"]
           [:url "https://www.eclipse.org/legal/epl-v10.html"]]
          :mpl
          [:license
           [:name "MPL-2.0"]
           [:url "https://www.mozilla.org/media/MPL/2.0/index.txt"]])]
       [:scm
        [:url url]
        [:connection (str "scm:git:git://github.com/" gh-project ".git")]
        [:developerConnection (str "scm:git:git://github.com/" gh-project ".git")]
        [:tag (:sha opts)]]
       [:dependencies]
       `[:build
         [:sourceDirectory "src"] ;; fine to hard code this, clj -Spom will change it if necessary
         [:resources
          ~@(for [dir (:resource-directories opts ["src" "resources"])]
              [:sourceDirectory dir])]
         [:plugins
          [:plugin
           [:groupId "org.apache.maven.plugins"]
           [:artifactId "maven-jar-plugin"]
           [:version "2.4"]
           [:configuration
            [:archive
             [:manifestEntries
              [:git-revision (:sha opts)]]]]]]]
       [:repositories
        [:repository
         [:id "clojars"]
         [:url "https://repo.clojars.org/"]]]
       [:distributionManagement
        [:repository
         [:id "clojars"]
         [:name "Clojars repository"]
         [:url "https://clojars.org/repo"]]]]))))
