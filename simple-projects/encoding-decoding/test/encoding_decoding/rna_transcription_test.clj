(ns encoding-decoding.rna-transcription-test
  (:require [clojure.test :refer [deftest is testing]]
            [encoding-decoding.rna-transcription :refer :all]))

(deftest rna-transcription-test
  (testing "transcribe cytosine to guanine"
    (is (= "G" (to-rna "C"))))

  (testing "transcribe guanine to cytosine"
    (is (= "C" (to-rna "G"))))

  (testing "transcribe adenine to uracil"
    (is (= "U" (to-rna "A"))))

  (testing "transcribe thymine to adenine"
    (is (= "A" (to-rna "T"))))

  (testing "transcribe all nucleotides"
    (is (= "UGCACCAGAAUU" (to-rna "ACGTGGTCTTAA"))))

  (testing "validate dna strands"
    (is (thrown? AssertionError (to-rna "XCGFGGTDTTAA")))))
