(ns hospital.collections
  [:use [clojure pprint]])

(defn test-vectors
  []
  (let [queue [111 222]]
    (println queue)
    (println (first queue))
    (println (rest queue))))

(test-vectors)


(defn test-lists
  []
  (let [queue '(111 222)]
    (println queue)
    (println (first queue))
    (println (pop queue))
    (println (rest queue))))

(test-lists)


(defn test-queue
  []
  (let [queue (conj clojure.lang.PersistentQueue/EMPTY 111 222)]
    (println queue)
    (println (seq queue))
    (println (seq (conj queue 333)))
    (-> queue
        (conj 333)
        seq
        println)
    (println (peek queue))
    (println (seq (pop queue)))
    (pprint queue)))

(test-queue)
