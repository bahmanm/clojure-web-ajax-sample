(ns clojure-web-ajax-sample.client.quadratic
  (:require [fetch.remotes])
  (:use [jayq.core :only [$ delegate data bind val text]])
  (:require-macros [fetch.macros :as fm]))

(def $a ($ :#a))
(def $b ($ :#b))
(def $c ($ :#c))
(def $message ($ :#message))
(def $result ($ :#result))

(defn display-quadratic-result [result]
  (text $message (:message result))
  (text $result
        (if (= (:status result) :ok)
          (str "X₁ = " (:x1 result) ", X₂ = " (:x2 result))
          "")))

(bind ($ :#solve)
      :click
      (fn [e]
        (let [a (val $a)
              b (val $b)
              c (val $c)]
          (fm/remote (solve a b c) [result]
                     (display-quadratic-result result)))))


