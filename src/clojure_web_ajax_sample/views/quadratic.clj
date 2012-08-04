(ns clojure-web-ajax-sample.views.quadratic
  (:require [clojure-web-ajax-sample.views.common :as common])
  (:use [noir.core :only [defpage]]
        [noir.fetch.remotes :only [defremote]]
        [hiccup.core :only [html]]))

(defpage "/quadratic" []
  (common/layout
   [:p [:b [:i "aX² + bX + c = 0"]] [:div#message]]
   [:p "a = " [:input#a {:type "text"}]]
   [:p "b = " [:input#b {:type "text"}]]
   [:p "c = " [:input#c {:type "text"}]]
   [:input#solve {:type "button" :value "Solve"}]
   [:div#result]))

(defremote solve [a b c]
  (let [a (BigDecimal. a)
        b (BigDecimal. b)
        c (BigDecimal. c)
        delta (- (* b b) (* 4 a c))]
    (if (< delta (BigDecimal/ZERO))
      {:status :fail
       :message "(\u0394 < 0) This equation has no real answers :-("}
      (if (= delta (BigDecimal/ZERO))
        {:status :ok
         :message "(\u0394 < 0) This equation has one answer."
         :x1 (/ (- b) (* 2 a)) :x2 (/ (- b) (* 2 a))}
        {:status :ok
         :message "(\u0394 > 0) This equation has two distinct answers."
         :x1 (/ (+ (- b) delta) (* 2 a)) :x2 (/ (- (- b) delta) (* 2 a))}))))