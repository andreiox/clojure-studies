(ns inventory.vectors)

(def prices [30 700 1000])

(println (prices 0))
(println (get prices 2))
(println (get prices 3))

(println (conj prices 13))

(println (inc 5))
(println (update prices 0 inc))


(defn get-discount-value
  [full-value]
  (* full-value 0.10))

(map get-discount-value prices)

(filter #(> %1 4) (range 10))


(reduce * (range 1 10))
(reduce #(* %1 %2) (range 1 10))
