(ns hospital.custom-validations
  (:use clojure.pprint)
  (:require [schema.core :as s]))

(defn positive?
  [number]
  (> number 0))

(def PositiveNumber (s/pred positive? 'scrict-positive))

(println (s/validate PositiveNumber 15))
(println (s/validate PositiveNumber "15"))
(println (s/validate PositiveNumber 0))
(println (s/validate PositiveNumber -10))

(def Patient
  "Patient schema"
  {:id (s/constrained s/Int positive?), :name s/Str})

(pprint (s/validate Patient {:id 15, :name "Andre"}))
