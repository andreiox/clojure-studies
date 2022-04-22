(ns hospital.core
  (:require [clojure.test.check.generators :as gen]))

(println (gen/sample gen/boolean 100))
(println (gen/sample gen/int 100))
(println (gen/sample gen/string))
(println (gen/sample gen/string-alphanumeric 100))

(println (gen/sample (gen/vector gen/int 5) 10))
