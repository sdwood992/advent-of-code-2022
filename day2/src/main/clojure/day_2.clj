(ns day-2
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(def result->points
  {:win 6
   :draw 3
   :lose 0})

(def shape->points
  {:rock 1
   :paper 2
   :scissors 3})


(def letter->shape
  {"A" :rock
   "B" :paper
   "C" :scissors
   "X" :rock
   "Y" :paper
   "Z" :scissors})

(def wins
  #{[:rock :scissors]
    [:paper :rock]
    [:scissors :paper]})

(defn round-result [[theirs yours]]
  (let [shape-score (shape->points yours)
        result (cond
                       (wins [yours theirs]) :win
                       (= yours theirs) :draw
                       :else :lose)]
    (+ shape-score (result->points result))))

(defn- read-input [input]
  (->> input
       io/resource
       slurp
       string/split-lines
       (map #(map letter->shape (string/split % #" ")))))


(defn strategy-guide-total [input]
  (->> (read-input input)
       (map round-result)
       (apply +)))




