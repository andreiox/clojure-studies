(ns hospital.partial)

(defn print-with-prefix
  ([prefix]
   (fn [message] (print-with-prefix prefix message)))
  ([prefix message]
   (println prefix message)))

(def print-fixed-prefix (print-with-prefix "Hello"))

(print-fixed-prefix "andreiox")
(print-with-prefix "hi," "Andre")

(defn print-with-parcial
  []
  (let [partial-print (partial print-with-prefix "Partial")]
    (partial-print "Success!")))

(print-with-parcial)
