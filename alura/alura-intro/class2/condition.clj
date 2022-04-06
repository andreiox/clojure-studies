(defn discounted-value
  [full-value]
  (if (> full-value 100)
    (let [discount 0.10]
      (* full-value (- 1 discount)))
    full-value))

(discounted-value 50)
