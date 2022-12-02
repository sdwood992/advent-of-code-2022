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
   "C" :scissors})

(defn- read-input [input]
  (->> input
       io/resource
       slurp
       string/split-lines))


(def wins
  #{[:rock :scissors]
    [:paper :rock]
    [:scissors :paper]})

(defn round-result-part-1 [[theirs yours]]
  (let [shape-score (shape->points yours)
        result (cond
                       (wins [yours theirs]) :win
                       (= yours theirs) :draw
                       :else :lose)]
    (+ shape-score (result->points result))))


(def part-1-letter->shape
  {"X" :rock
   "Y" :paper
   "Z" :scissors})

(defn strategy-guide-assumed-total [input]
  (->> (read-input input)
       (map #(map (merge letter->shape part-1-letter->shape) (string/split % #" ")))
       (map round-result-part-1)
       (apply +)))


(def result-shape->shape
  {[:win :rock] :paper
   [:win :paper] :scissors
   [:win :scissors] :rock
   [:draw :rock] :rock
   [:draw :paper] :paper
   [:draw :scissors] :scissors
   [:lose :rock] :scissors
   [:lose :paper] :rock
   [:lose :scissors] :paper})


(defn round-result-part-2 [[theirs result]]
  (let [yours (result-shape->shape [result theirs])
        shape-score (shape->points yours)
        result-score (result->points result)]
    (+ shape-score result-score)))

(def part-2-letter->result
  {"X" :lose
   "Y" :draw
   "Z" :win})

(defn strategy-guide-correct-total [input]
  (->> (read-input input)
       (map #(map (merge letter->shape part-2-letter->result) (string/split % #" ")))
       (map round-result-part-2)
       (apply +)))




