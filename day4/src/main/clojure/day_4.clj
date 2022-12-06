(ns day-4
  (:require [clojure.java.io :as io]
            [clojure.string :as string]
            [clojure.set :as set]))

(defn- explode [[low high]]
  (set (range low (inc high))))

(defn- read-input [input]
  (->> input
       io/resource
       slurp
       string/split-lines
       (map (fn [pair-assignments-line]
              (let [[pair-1 pair-2] (->> (string/split pair-assignments-line #",")
                                         (map #(->> (string/split % #"-")
                                                    (map parse-long))))]
                [(explode pair-1)
                 (explode pair-2)])))))

(defn overalapping-assignments [input]
  (->> (read-input input)
       (filter (fn [[assignments-1 assignments-2]]
                 (some nil? [(seq (set/difference assignments-1 assignments-2))
                             (seq (set/difference assignments-2 assignments-1))])))
       count))




