(ns hospital.logic
  (:require (hospital.model)))

(defn now
  []
  (hospital.model/to-ms (java.util.Date.)))
