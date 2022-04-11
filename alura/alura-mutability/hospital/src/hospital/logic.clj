(ns hospital.logic)

(defn full-queue?
  [hospital queue]
  (-> hospital
      (get queue)
      count
      (>= 2)))

(defn arrive-at
  [hospital queue person]
  (if (full-queue? hospital queue)
    (throw (ex-info "full queue, meu chapa" {:person person}))
    (update hospital queue conj person)))

(defn arrive-at-swap!
  [hospital queue person]
  (if (full-queue? hospital queue)
    (throw (ex-info "full queue, meu chapa" {:person person}))
    (swap! hospital update queue conj person)))

(defn attend
  [hospital queue]
  (let [person (peek (get hospital queue))]
    (println "helping this person: " person)
    (update hospital queue pop)))
