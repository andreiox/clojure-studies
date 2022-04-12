(ns hospital.do)

(defn doseq-example
  []
  (let [arr ["123" "456" "789"]]
    (doseq [el arr]
      (println el))))

(doseq-example)

(defn dotimes-example
  []
  (dotimes [n 6]
    (println n)))

(dotimes-example)
