(ns hospital.schemas
  (:use clojure.pprint)
  (:require [schema.core :as s]))

(println (s/validate Long 15))

(defn print-patient-id
  [patient]
  (println (:id patient)))

(defn test-print-patient-id
  []
  (let [patient1 {:id 1, :name "Andre"}
        patient2 {:name "Eduarda"}]
    (print-patient-id patient1)
    (print-patient-id patient2)))

(test-print-patient-id)


(s/set-fn-validation! true)

(s/defn simple-test
  [number :- Long]
  (println number))

(simple-test 18)
(simple-test "Andre")


(def Patient
  "Patient schema"
  {:id Long
   :name String})

(s/defn print-patient-id-with-validation
  [patient :- Patient]
  (println (:id patient)))

(defn test-print-patient-id-with-validation
  []
  (let [patient1 {:id 1, :name "Andre"}
        patient2 {:name "Eduarda"}]
    (print-patient-id-with-validation patient1)
    (print-patient-id-with-validation patient2)))

(test-print-patient-id-with-validation)


(def Patients
  "Patients schema"
  {(:key :- Long) {:id Long
                   :name String
                   (s/optional-key :birthdate) s/Str}})

(s/validate Patients {15 {:id 15, :name "Andre" :birthdate "1996-02-05"}})
