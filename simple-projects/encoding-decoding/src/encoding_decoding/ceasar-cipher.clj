(ns encoding-decoding.ceasar-cipher)

(defn encode
  [string]
  (let [encoded (map int string)
        encoded (map #(+ % 6) encoded)
        encoded (apply str (map char encoded))]
    encoded))

(defn decode
  [string]
  (let [decoded (map int string)
        decoded (map #(- % 6) decoded)
        decoded (apply str (map char decoded))]
    decoded))
