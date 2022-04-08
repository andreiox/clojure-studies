(ns store.logic)

(defn total-item
  [item]
  (* (get item :unit-price 0) (get item :quantity 0)))

(defn total-order
  [order]
  (->> order
       vals
       (map total-item)
       (reduce +)))

(defn total-orders
  [orders]
  (->> orders
       (map :items)
       (map total-order)))

(defn count-per-user
  [[key value]]
  {:user key
   :count (count value)
   :total-price (reduce + (total-orders value))})

(defn summary-per-user
  [orders]
  (->> orders
       (group-by :user)
       (map count-per-user)))
