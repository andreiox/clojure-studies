(defn discounted-value
  [full-value]
  (def discount 0.10) "using def, this will be a global symbol"
  (* full-value (- 1 discount)))

(discounted-value 50)


(defn discounted-value
  [full-value]
  "let will make discount local but only inside let scope"
  (let [discount 0.10]
    (* full-value (- 1 discount))))

(discounted-value 50)
