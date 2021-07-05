(ns lioss.pom
  (:require [clojure.string :as str]
            [lioss.hiccup :as hiccup]
            [lioss.util :as util]
            [lioss.subshell :as subshell]))

(defn pom-deps [deps]
  (for [[artifact coords] deps]
    (do
      (when-not (:mvn/version coords)
        (println "WARN: can't add to pom.xml" artifact coords))
      [:dependency
       [:groupId (if (qualified-symbol? artifact)
                   (namespace artifact)
                   (str artifact))]
       [:artifactId (if (qualified-symbol? artifact)
                      (name artifact)
                      (str artifact))]
       [:version (:mvn/version coords)]])))

(defn pom-alias-deps [opts]
  (concat
   (when-let [aliases (:aliases-as-scope-provided opts)]
     (for [alias aliases
           dep (pom-deps (get-in opts [:aliases alias :extra-deps]))]
       (conj dep [:scope "provided"])))
   (when-let [aliases (:aliases-as-optional-deps opts)]
     (for [alias aliases
           dep (pom-deps (get-in opts [:aliases alias :extra-deps]))]
       (conj dep [:optional "true"])))))

(defn hiccup->xml [h]
  (str "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" (hiccup/h h)))

(defn regular-pom [opts]
  (assert (:name opts))
  (assert (:version opts))
  (let [proj-name (:name opts)
        gh-project (:gh-project opts)
        url (:url opts (str "https://github.com/" gh-project))
        paths (concat (get-in opts [:aliases :lioss/release :extra-paths])
                      (:paths opts))]
    [:project {:xmlns "http://maven.apache.org/POM/4.0.0",
               :xmlns:xsi "http://www.w3.org/2001/XMLSchema-instance",
               :xsi:schemalocation
               "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"}
     [:modelVersion "4.0.0"]
     [:groupId (:group-id opts)]
     [:artifactId proj-name]
     [:version (:version opts)]
     [:name proj-name]
     [:description (:description opts)]
     [:url url]
     [:inceptionYear (:inception-year opts)]
     [:organization
      [:name (:org-name opts)]
      [:url (:org-url opts)]]
     (when (:license opts)
       [:licenses
        (case (:license opts)
          :epl
          [:license
           [:name "Eclipse Public License 1.0"]
           [:url "https://www.eclipse.org/legal/epl-v10.html"]]
          :mpl
          [:license
           [:name "MPL-2.0"]
           [:url "https://www.mozilla.org/media/MPL/2.0/index.txt"]])])
     [:scm
      [:url url]
      [:connection (str "scm:git:git://github.com/" gh-project ".git")]
      [:developerConnection (str "scm:git:ssh://git@github.com/" gh-project ".git")]
      [:tag (:sha opts)]]
     `[:dependencies ~@(concat
                        (pom-deps (:deps opts))
                        (pom-alias-deps opts))]
     [:build
      (when (seq (:paths opts))
        [:sourceDirectory (first (:paths opts))])
      (when (seq paths)
        `[:resources
          ~@(for [dir paths]
              [:resource
               [:directory dir]])])
      [:plugins
       [:plugin
        [:groupId "org.apache.maven.plugins"]
        [:artifactId "maven-compiler-plugin"]
        [:version "3.8.1"]]
       [:plugin
        [:groupId "org.apache.maven.plugins"]
        [:artifactId "maven-jar-plugin"]
        [:version "3.2.0"]
        [:configuration
         [:archive
          [:manifestEntries
           [:git-revision (:sha opts)]]]]]
       [:plugin
        [:groupId "org.apache.maven.plugins"]
        [:artifactId "maven-gpg-plugin"]
        [:version "1.6"]
        [:executions
         [:execution
          [:id "sign-artifacts"]
          [:phase "verify"]
          [:goals [:goal "sign"]]]]]]]
     (into
      [:repositories
       [:repository
        [:id "clojars"]
        [:url "https://repo.clojars.org/"]]]
      (map (fn [[id {:keys [url]}]]
             [:repository
              [:id id]
              [:url url]]))
      (:mvn/repos opts))
     [:distributionManagement
      [:repository
       [:id "clojars"]
       [:name "Clojars repository"]
       [:url "https://clojars.org/repo"]]]]))

(defn relocation-pom [opts]
  (let [proj-name (:name opts)
        gh-project (:gh-project opts)
        url (:url opts (str "https://github.com/" gh-project))
        paths (concat (get-in opts [:aliases :lioss/release :extra-paths])
                      (:paths opts))]
    [:project {:xmlns "http://maven.apache.org/POM/4.0.0"
               :xmlns:xsi "http://www.w3.org/2001/XMLSchema-instance"
               :xsi:schemalocation "http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd"}
     [:modelVersion "4.0.0"]
     [:groupId (:old-group-id opts)]
     [:artifactId proj-name]
     [:version (:version opts)]
     [:distributionManagement
      [:relocation
       [:groupId (:group-id opts)]]
      [:repository
       [:id "clojars"]
       [:name "Clojars repository"]
       [:url "https://clojars.org/repo"]]]]))

(defn spit-pom [h]
  (util/spit-cwd "pom.xml" (hiccup->xml h)))

(defn spit-poms [opts]
  (spit-pom (regular-pom opts))
  (util/do-modules opts (comp spit-pom regular-pom)))

(defn spit-relocation-poms [opts]
  (spit-pom (relocation-pom opts))
  (util/do-modules opts (comp spit-pom relocation-pom)))
