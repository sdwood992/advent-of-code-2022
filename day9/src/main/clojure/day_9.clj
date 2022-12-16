(ns day-9
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(defn read-input [input]
  (->> input
       io/resource
       slurp
       string/split-lines
       (map (fn [line]
              (let [[[_ direction steps]] (re-seq #"(R|L|D|U) ([0-9]+)" line)]
                {:direction direction
                 :steps steps}) ))))

(defn blah []
  (let [greeting "Hello, World!!!"]
    (println greeting)
    greeting))




