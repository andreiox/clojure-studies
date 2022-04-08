(ns store.recursion)

(def arr (range 10000))

(defn my-map
  [func sequence]
  (let [first (first sequence)]
    (if (not (nil? first))
      (do
        (func first)
        (my-map func (rest sequence))))))

(my-map println arr)

(defn my-map-tail-recur
  [func sequence]
  (let [first (first sequence)]
    (if (not (nil? first))
      (do
        (func first)
        (recur func (rest sequence))))))

(my-map-tail-recur println arr)


(def arr2 (range 10))

(println (reduce #(+ %1 %2) arr2))

(defn my-reduce
  ([func sequence]
   (my-reduce func 0 sequence))
  ([func val sequence]
   (if (empty? sequence)
     val
     (recur func (func val (first sequence)) (rest sequence)))))

(my-reduce + arr2)
