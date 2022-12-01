(ns day-1
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(defn- read-and-parse-input [input]
  (->> input
       io/resource
       slurp
       string/split-lines
       (map #(when-not (string/blank? %)
               (Long/parseLong %)))
       (partition-by nil?)
       (remove #(every? nil? %))
       (map #(apply + %))))

(defn most-calories-carried-by-an-elf
  "day 1 part 1"
  [input]
  (->> input
       read-and-parse-input
       (apply max)))

(defn calories-carried-by-the-top-3-elves
  "day 1 part 2"
  [input]
  (->> input
       read-and-parse-input
       (sort >)
       (take 3)
       (apply +)))




