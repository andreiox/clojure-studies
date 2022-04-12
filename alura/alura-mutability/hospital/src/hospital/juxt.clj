(ns hospital.juxt
  [:require [hospital.model]]
  [:use (clojure pprint)])

(def queue hospital.model/empty-queue)
(def queue (conj queue 1))
(def queue (conj queue 2))
(def queue (conj queue 3))

(pprint queue)

(def peek-pop (juxt peek pop))

(def juxted (peek-pop queue))

(println (juxted 0))
(pprint (juxted 1))
