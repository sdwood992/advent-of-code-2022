(ns day-3
  (:require [clojure.java.io :as io]
            [clojure.string :as string]
            [clojure.set :as set]))

(defn char-range [start end]
  (map char (range (int start) (inc (int end)))))

(def item->priority
  (zipmap (concat (char-range \a \z) (char-range \A \Z) ) (map inc (range))))

(defn- check-line? [line]
  (if (even? (count line))
    line
    (throw (ex-info "Line with odd number of characters foudn, this is unexpected" {:line line}))))

(defn- read-input [input]
  (->> input
       io/resource
       slurp
       string/split-lines
       (map check-line?)
       (map seq)
       (map (fn [rucksack-contents]
              [(set (take (-> rucksack-contents count (/ 2)) rucksack-contents))
               (set (drop (-> rucksack-contents count (/ 2)) rucksack-contents))]))))

(defn rucksack-prioritisation [input]
  (->> (read-input input)
       (mapcat #(apply set/intersection %))
       (map item->priority)
       (apply +)))




