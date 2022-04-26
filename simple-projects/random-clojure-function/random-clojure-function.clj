(def functions (keys (ns-publics 'clojure.core)))

(println (nth functions (rand-int (count functions))))
(println (rand-nth functions))
