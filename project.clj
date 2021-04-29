(defproject inquery "0.1.13"
  :description "see qua l"
  :url         "https://github.com/tolitius/inquery"
  :scm         {:url "https://github.com/tolitius/inquery"}
  :license     {"Eclipse Public License"
                "http://www.eclipse.org/legal/epl-v10.html"}
  
  :plugins [[lein-doo "0.1.11"]]
  
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/clojurescript "1.10.773"]]
  
  :source-paths ["src" "src-browser"]
  
  :cljsbuild
  {:builds [{:id "test-node"
             :source-paths ["src" "src-node" "test"]
             :compiler {:output-to "resources/public/js/testable.js"
                        :main inquery.runner
                        :optimizations :none
                        :target :nodejs}}]})