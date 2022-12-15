(ns day-8
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))
(defn row [trees r]
  (nth trees r))

(defn col [trees c]
  (-> (apply map vector trees)
      vec
      (nth c)))

(defn tree-at [trees r c]
  (nth (row trees r) c))

(defn read-input [input]
  (->> input
       io/resource
       slurp
       string/split-lines
       (map (fn [line]
              (->> line
                   seq
                   (map (comp parse-long str))
                   vec) ))
       vec))

(defn visible? [trees [x y]]
  (let [tree-in-question (tree-at trees x y)
        row (row trees x)
        col (col trees y)
        trees-to-left (take y row)
        trees-to-right (drop (inc y) row)
        trees-to-top (take x col)
        trees-to-bottom (drop (inc x) col)]
    (or (every? #(< % tree-in-question) trees-to-left)
        (every? #(> tree-in-question %) trees-to-right)
        (every? #(< % tree-in-question) trees-to-top)
        (every? #(> tree-in-question %) trees-to-bottom))))

(defn visible-trees [input]
  (let [trees (read-input input)
        trees-to-check (for [x (range 0 (-> trees first count))
                             y (range 0 (-> trees count))]
                         [x y])]
    (->> trees-to-check
         (filter (partial visible? trees))
         count)))




