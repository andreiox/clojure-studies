(ns inventory.hashmap)

(def inventory {"Mochila" 10,
                "Camiseta" 5})

(println inventory)
(println (count inventory))
(println (keys inventory))
(println (vals inventory))


;; keyword
;; :mochila
(def inventory-with-keywords {:mochila 10,
                              :camiseta 5})

(println inventory-with-keywords)


(println (assoc inventory :cadeira 2))
(println (assoc inventory-with-keywords :mochila 1))
(println (update inventory-with-keywords :mochila inc))

(println (dissoc inventory-with-keywords :mochila))


(def order {:mochila {:qtd 2, :price 100}
            :camiseta {:qtd 1, :price 20}})

(println order)
(println (order :mochila))
(println (get order :mochila))
(println (get order :cadeira {}))
(println (:camiseta order))

(println (:price (:mochila order)))


(println (update-in order [:mochila :qtd] inc))


(println (-> order
             :mochila
             :price))
(println (-> order :camiseta :qtd))


(defn qtd-greater-than-one
  [[key value]]
  (> (:qtd value) 1))

(println (filter qtd-greater-than-one order))


(defn increase-qtd
  [[_ value]]
  (update value :qtd inc))

(println (map increase-qtd order))


(defn sum-qtd
  [sum, [_ value]]
  (+ sum (-> value :qtd)))

(println (reduce sum-qtd 0 order))


(defn total-price-product
  [product]
  (* (:qtd product) (:price product)))

(defn total-price-order
  [order]
  (->> order
       vals
       (map total-price-product)
       (reduce +)))

(println (total-price-order order))


(defn always-true
  []
  true)

(println (always-true))
(println (not (always-true)))

(def always-false (comp not always-true))
(println (always-false))
