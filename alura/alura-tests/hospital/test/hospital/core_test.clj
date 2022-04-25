(ns hospital.core-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.clojure-test :refer (defspec)]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [hospital.core :refer :all]))

(deftest greater-than-5?-test
  (testing "random numbers are greater than 5"
    (doseq [number (gen/sample gen/small-integer)]
      (is (= (> number 5) (greater-than-5? number))))))

(defspec exploring-api 10
  (prop/for-all
   [number (gen/vector gen/string-alphanumeric 0 4)
    string gen/string-alphanumeric]
   (println number string)
   true))
