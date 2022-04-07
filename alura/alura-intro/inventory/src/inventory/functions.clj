(ns inventory.functions)

(defn discounted-value
  [full-value]
  (if (> full-value 100)
    (let [discount 0.10]
      (* full-value (- 1 discount)))
    full-value))

(discounted-value 150)


(defn is-greater-than-100?
  [full-value]
  (> full-value 100))

(defn discounted-value-refactor
  [apply? full-value]
  (if (apply? full-value)
    (let [discount 0.10]
      (* full-value (- 1 discount)))
    full-value))

(discounted-value-refactor is-greater-than-100? 100)


(discounted-value-refactor (fn [full-value] (> full-value 100)) 1000)
(discounted-value-refactor #(> %1 100) 101)
