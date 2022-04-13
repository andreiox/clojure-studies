(ns hospital.defrecord
  (:use clojure.pprint))

(defn add-patient
  [patients patient]
  (if-let [id (:id patient)]
    (assoc patients id patient)
    (throw (ex-info "Patient without id" {:patient patient}))))

(def patients {})

(def patient1 {:id 10 :name "Andre"})
(def patient2 {:id 11 :name "Daniela"})
(def patient3 {:name "Paulo"})

(pprint (add-patient patients patient1))
(pprint (add-patient patients patient2))
(pprint (add-patient patients patient3))


(defrecord Patient [id name])

(pprint (->Patient 15 "Andre"))
(pprint (map->Patient {:id 15, :name "Andre"}))
(pprint (= (map->Patient {:id 15, :name "Andre"}) (->Patient 15 "Andre")))
(pprint (= (map->Patient {:id 10, :name "Daniela"}) (->Patient 15 "Andre")))
