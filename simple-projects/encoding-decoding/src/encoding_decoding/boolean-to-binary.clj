(ns encoding-decoding.boolean-to-binary)

(defn boolean-to-binary-map
  [boolean-value]
  (let [conversion-map {false 0 true 1}]
    (get conversion-map boolean-value)))
