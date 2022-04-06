(defn welcome-message []
  (println "Welcome my boy!"))

(welcome-message)


(defn apply-discount
  [full-value]
  (* full-value 0.9))

(apply-discount 100)


(defn discounted-value
  "Apply 10% discount in full value"
  [full-value]
  (* full-value (- 1 0.1)))

(discounted-value 1000)
