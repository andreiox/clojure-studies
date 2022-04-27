(ns most-common-word.common-words)

(defn decode-book
  [book-gzip]
  (with-open
    [uncompress-text (java.util.zip.GZIPInputStream.
                      (clojure.java.io/input-stream book-gzip))]
    (slurp uncompress-text)))

(defn common-words
  [csv]
  (-> (slurp csv)
      (clojure.string/split #",")
      set))

(defn most-common-word
  [book-gzip common-words]
  (->> (decode-book book-gzip)
       (re-seq #"[\w|'-]+")
       (map #(clojure.string/lower-case %))
       (remove common-words)
       frequencies
       (sort-by val >)))

(defn -main
  [book-gzip common-word-csv]
  (most-common-word book-gzip (common-words common-word-csv)))

(def results (-main
              "https://www.gutenberg.org/cache/epub/844/pg844.txt"
              "https://practical.li/clojure/simple-projects/data-transformation/common-english-words.csv"))

(println (take 10 results))
