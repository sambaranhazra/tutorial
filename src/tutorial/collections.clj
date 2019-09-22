(ns tutorial.collections)

(let [my-vec [1 2 3]]
  (my-vec 2))

(let [my-map {:a 1 :b 2 :c 3}]
  (my-map :d))

(let [my-set #{:a :b :c :d}]
  (my-set :d))

(let [my-fun (fn [] :name)
      my-map {:name "Sambaran" :surname "Hazra"}
      name (my-fun)]
  (name my-map))

(let [my-map {:a 1 :b 2}]
  (assoc my-map :c 3))