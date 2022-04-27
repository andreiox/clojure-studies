(ns encoding-decoding.rna-transcription)

(defn nucleotide-complement
  [nucleotide]
  (case (str nucleotide)
    "G" "C"
    "C" "G"
    "T" "A"
    "A" "U"
    (throw (AssertionError. "Wrong input"))))

(defn to-rna
  [dna-strand]
  (apply str (map nucleotide-complement dna-strand)))
