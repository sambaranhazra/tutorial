(ns tutorial.fundamentals
  (:require [clojure.string :as s]))

(println "Hello"
         (+ 2 3)
         "\n"
         (slurp "D:\\projects\\clojure_projects\\tutorial\\src\\tutorial\\core.clj"))

\tab

(type #".*")
(type :name)
[1 2 3]
{:a 1 :b 2}
#{:a :b}
(list 1 2 3 4)

(println (s/upper-case "hello"))
(println (s/capitalize "sambaran"))

(def ^:private names "Sambaran")
(defn mangle [str]
  (s/join "-" (s/reverse str)))
(defn de-mangle [mangle-str]
  (s/reverse
    (s/join ""
            (s/split mangle-str #"-"))))

(defn palindrome? [word]
  (let [lower-case (s/lower-case word)]
    (not= lower-case (s/reverse lower-case))))

(cond (= 1 1) "true")
(defn find-largest [[nums]]
  (max nums))

(defn factorial [num]
  (loop [n num r 1N]
    (if (<= n 1) r (recur (dec n) (* n r)))))
(def names
  (s/split (slurp "D:\\projects\\clojure_projects\\tutorial\\resources\\names.txt") #"\r\n"))