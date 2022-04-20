(ns hospital.logic)

(defn can-add-in-queue?
  [hospital department]
  (-> hospital
      department
      count
      (< 5)))
