(ns hospital.logic-test
  (:require [clojure.test :refer :all]
            [hospital.logic :refer :all]))

(deftest can-add-in-queue?-test
  (testing "fit in queue"
    (is (can-add-in-queue? {:waiting []} :waiting)))

  (testing "fit in queue with 2 people"
    (is (can-add-in-queue? {:waiting [1 2]} :waiting)))

  (testing "fit in queue with 4 people"
    (is (can-add-in-queue? {:waiting [1 2 3 4]} :waiting)))

  (testing "not fit in queue"
    (is (not (can-add-in-queue? {:waiting [1 2 3 4 5]} :waiting))))

  (testing "not fit in queue"
    (is (not (can-add-in-queue? {:waiting [1 2 3 4 5 6]} :waiting))))

  (testing "department dont exists"
    (is (not (can-add-in-queue? {:waiting [1 2 3 4 5]} :x-ray)))))

(deftest can-add-in-queue-throw?-test
  (testing "exception test"
    (is (try
          (can-add-in-queue-throw? {:waiting [1 2 3 4 5]} :waiting)
          false
          (catch clojure.lang.ExceptionInfo e
            (= "full" (:msg (ex-data e))))))))
