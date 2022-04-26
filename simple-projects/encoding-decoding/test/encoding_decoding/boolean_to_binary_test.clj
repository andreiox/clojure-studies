(ns encoding-decoding.boolean-to-binary-test
  (:require [clojure.test :refer :all]
            [encoding-decoding.boolean-to-binary :refer :all]))

(deftest boolean-to-binary-map-test
  (testing "false returns 0"
    (is (= (boolean-to-binary-map false) 0)))

  (testing "true returns 1"
    (is (= (boolean-to-binary-map true) 1)))

  (testing "not boolean returns nil"
    (is (= (boolean-to-binary-map "aaa") nil))))
