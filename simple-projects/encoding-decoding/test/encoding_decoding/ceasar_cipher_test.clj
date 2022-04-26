(ns encoding-decoding.ceasar-cipher-test
  (:require [clojure.test :refer :all]
            [encoding-decoding.ceasar-cipher :refer :all]))

(deftest encode-test
  (testing "encode andreiox"
    (is (= (encode "andreiox") "gtjxkou~"))))

(deftest decode-test
  (testing "decode gtjxkou~"
    (is (= (decode "gtjxkou~") "andreiox"))))

; test with generators
