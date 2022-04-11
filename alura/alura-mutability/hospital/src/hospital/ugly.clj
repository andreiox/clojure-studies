(ns hospital.ugly
  [:use [clojure pprint]]
  [:require [hospital.model]
   [hospital.logic]])

(defn simulate-one-day
  []
  (def hospital (hospital.model/new-hospital))
  (def hospital (hospital.logic/arrive-at hospital :queue 111))
  (def hospital (hospital.logic/arrive-at hospital :queue 222))
  (def hospital (hospital.logic/arrive-at hospital :queue 333))
  (def hospital (hospital.logic/arrive-at hospital :lab1 444))
  (def hospital (hospital.logic/arrive-at hospital :lab2 555))
  (pprint hospital)

  (def hospital (hospital.logic/attend hospital :lab1))
  (pprint hospital))

(simulate-one-day)
