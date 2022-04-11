(ns hospital.logic)

(defn arrive-at
  [hospital queue person]
  (update hospital queue conj person))

(defn attend
  [hospital queue]
  (let [person (peek (get hospital queue))]
    (println "helping this person: " person)
    (update hospital queue pop)))
