(ns clojure-web-ajax-sample.views.welcome
  (:require [clojure-web-ajax-sample.views.common :as common])
  (:use [noir.core :only [defpage]]))

(defpage "/" []
  (common/layout
   [:h1 "Welcome to clojure-web-ajax-sample!"]
   [:p "You can now:"]
   [:ul
    [:li [:a {:href "/quadratic"} "Solve a quadratic equation"]]]))
