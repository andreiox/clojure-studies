(ns store.db)

(def order1 {:user 15
             :items {:bag {:id :bag :quantity 2 :unit-price 80}
                     :shirt {:id :shirt :quantity 3 :unit-price 40}
                     :sneaker {:id :sneaker :quantity 1}}})

(def order2 {:user 11
             :items {:bag {:id :bag :quantity 1 :unit-price 8}
                     :shirt {:id :shirt :quantity 1 :unit-price 3}
                     :sneaker {:id :sneaker :quantity 3}}})

(def order3 {:user 12
             :items {:bag {:id :bag :quantity 1 :unit-price 15}
                     :shirt {:id :shirt :quantity 6 :unit-price 43}
                     :sneaker {:id :sneaker :quantity 5}}})

(def order4 {:user 15
             :items {:bag {:id :bag :quantity 1 :unit-price 20}
                     :shirt {:id :shirt :quantity 1 :unit-price 10}
                     :sneaker {:id :sneaker :quantity 3}}})

(defn all-orders
  []
  [order1, order2, order3, order4])
