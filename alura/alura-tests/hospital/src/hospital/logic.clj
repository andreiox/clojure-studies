(ns hospital.logic)

(defn can-add-in-queue?
  [hospital department]
  (some-> hospital
          department
          count
          (< 5)))

(defn can-add-in-queue-throw?
  [hospital department]
  (let [count (count (department hospital))]
    (if (< count 5)
      true
      (throw (ex-info "Queue full" {:queue department, :msg "full"})))))
