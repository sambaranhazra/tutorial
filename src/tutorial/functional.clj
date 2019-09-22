(ns tutorial.functional
  (:require [clojure.string :as string]
            [tutorial.fundamentals :as fundamentals]))

(map (fn [s]
       (string/upper-case s))
     fundamentals/names)
(get
  (into (sorted-map)
        (group-by
          (fn [s]
            (subs s 0 1))
          fundamentals/names)) "A")

(defn fibo-rec [num]
  (cond
    (<= num 0) 0N
    (= num 1) 1N
    :else (+ (fibo-rec (- num 1)) (fibo-rec (- num 2)))))

(defn fibo-tail-rec [num]
  (loop [n num a 0N b 1N]
    (cond
      (= n 0) a
      (= n 1) b
      :else (recur (- n 1) b (+ a b)))))

(defn fibo-reduce [num]
  (first
    (reduce
      (fn [acc _]
        [(second acc) (+ (first acc) (second acc))])
      [0N 1N] (range num))))

(defn fact-reduce [num]
  (reductions
    (fn [acc n]
      (* acc n))
    1N (range 2 (inc num))))

(reductions
  (fn [acc n]
    (* acc n))
  1N (range 1 10))

(defn our-filter [func coll]
  (reduce
    (fn [acc elem]
      (if (func elem)
        (conj acc elem)
        acc))
    (empty coll)
    coll))

(our-filter (fn [map-elem]
              (if (= (key map-elem) "Sambaran")
                true
                false))
            {:name "Sambaran"})