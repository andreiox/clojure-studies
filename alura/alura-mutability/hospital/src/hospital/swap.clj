(ns hospital.swap
  (:use [clojure pprint])
  (:require [hospital.logic]
            [hospital.model]))

(defn test-atom
  []
  (let [hospital-atom (atom {:espera hospital.model/empty-queue})]
    (pprint hospital-atom)
    (pprint @hospital-atom)
    (swap! hospital-atom assoc :lab1 hospital.model/empty-queue)
    (pprint @hospital-atom)
    (swap! hospital-atom assoc :lab2 hospital.model/empty-queue)
    (pprint @hospital-atom)
    (swap! hospital-atom update :lab1 conj "111")
    (pprint @hospital-atom)))

; (test-atom)

(defn simulate-one-day-paralel
  []
  (let [hospital (atom (hospital.model/new-hospital))]
    (.start (Thread. (fn [] (pprint {:hello "world"}))))
    (.start (Thread. (fn [] (hospital.logic/arrive-at-swap! hospital :queue 111))))
    (.start (Thread. (fn [] (hospital.logic/arrive-at-swap! hospital :queue 222))))
    (.start (Thread. (fn [] (Thread/sleep 4000)
                       (pprint @hospital))))))

(simulate-one-day-paralel)
