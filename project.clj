(defproject clojure-web-ajax-sample "0.1.0-SNAPSHOT"
  :description "Sample webapp written using ClojureScript and Noir"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [noir "1.3.0-beta3"]
                 [jayq "0.1.0-alpha4"]
                 [crate "0.2.0-alpha4"]
                 [fetch "0.1.0-alpha2"]]
  :plugins [[lein-swank "1.4.4"]
            [lein-cljsbuild "0.2.5"]]
  :cljsbuild {:builds
              [{:builds nil,
                :jar true
                :source-path "src"
                :compiler {:output-dir "resources/public/cljs/"
                           :output-to "resources/public/cljs/bootstrap.js"
                           :optimization :simple
                           :pretty-print true}}]}
  :hooks [leiningen.cljsbuild]
  :main anahid.server)

