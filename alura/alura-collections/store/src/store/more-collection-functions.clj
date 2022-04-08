(ns store.more-collection-functions
  (:require [store.db])
  (:require [store.logic]))

(println (store.db/all-orders))

(def orders (store.db/all-orders))
(def summary (store.logic/summary-per-user orders))

(println (sort-by :total-price summary))
(println (reverse (sort-by :total-price summary)))

(println (get-in orders [0 :items :bag :quantity]))


(defn summary-per-user-sorted
  [orders]
  (->> orders
       store.logic/summary-per-user
       (sort-by :total-price)
       reverse))

(println (summary-per-user-sorted orders))
(println (first (summary-per-user-sorted orders)))
(println (take 2 (summary-per-user-sorted orders)))

(println (some #(> (:total-price %) 500) summary))
