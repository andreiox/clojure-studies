(ns hospital.component
  (:use clojure.pprint)
  (:require (hospital.logic)
            (hospital.model)))

(defn get-patient
  [id]
  (println "get-patient" id)
  (Thread/sleep 1000)
  {:id id, :retrieved-at (hospital.logic/now)})

(defn get-with-cache
  [cache getter id]
  (if (contains? cache id)
    cache
    (let [patient (getter id)]
      (assoc cache id patient))))

; (def patients {})
; (def patients (get-with-cache patients get-patient 15))
; (pprint patients)
; (def patients (get-with-cache patients get-patient 20))
; (pprint patients)
; (def patients (get-with-cache patients get-patient 15))
; (pprint patients)


(defprotocol Loadable
  (load! [this id]))

(defrecord Cache
  [cache getter]
  Loadable
  (load! [this id]
    (swap! cache get-with-cache getter id)
    (get @cache id)))

(def patients (->Cache (atom {}) get-patient))
(pprint patients)

(load! patients 15)
(load! patients 20)
(load! patients 15)

(pprint patients)
