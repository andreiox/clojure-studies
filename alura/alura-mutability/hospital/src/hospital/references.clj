(ns hospital.references
  [:require [hospital.model]]
  [:use [clojure pprint]])

(def hospital {:lab1 (ref hospital.model/empty-queue)
               :lab2 (ref hospital.model/empty-queue)
               :lab3 (ref hospital.model/empty-queue)})

(dosync
 (ref-set (:lab1 hospital) (conj @(:lab1 hospital) "123")))

(dosync
 (alter (:lab1 hospital) conj "456"))

(pprint hospital)
