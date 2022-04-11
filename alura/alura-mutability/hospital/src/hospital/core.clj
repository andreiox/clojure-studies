(ns hospital.core
  [:use [clojure pprint]]
  [:require [hospital.model]])

(def hospital (hospital.model/new-hospital))

(pprint hospital)
