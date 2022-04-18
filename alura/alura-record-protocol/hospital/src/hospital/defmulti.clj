(ns hospital.defmulti
  (:use clojure.pprint))

(defmulti multi-test odd?)
(defmethod multi-test true [number] "This is and odd number")
(defmethod multi-test false [number] "This is and even number")

(multi-test 30)
(multi-test 31)
