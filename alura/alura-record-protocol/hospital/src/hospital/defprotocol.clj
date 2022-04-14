(ns hospital.defprotocol
  (:use clojure.pprint))

(defrecord Patient [id name])
(pprint (->Patient 15 "Andre"))

(defprotocol Chargeable
  (sign-pre-authorization? [patient procedure value]))

(extend-type Patient
  Chargeable
  (sign-pre-authorization? [patient procedure value]
    (>= value 50)))

(def patient (->Patient 10 "Andre"))
(pprint (sign-pre-authorization? patient :x-ray 500))
(pprint (sign-pre-authorization? patient :x-ray 40))


(defprotocol Dateable
  (to-ms [this]))

(extend-type java.lang.Number
  Dateable
  (to-ms [this] this))

(pprint (to-ms 56))


(extend-type java.util.Date
  Dateable
  (to-ms [this] (.getTime this)))

(pprint (to-ms (java.util.Date.)))
