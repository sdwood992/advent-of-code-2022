(ns day-1
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(defn most-calories-carried-by-an-elf [input]
  (let [greeting "Hello, World!!!"]
    (->> input
         io/resource
        slurp
         string/split-lines
         (map #(when-not (string/blank? %)
                 (Long/parseLong %)))
         (partition-by nil?)
         (remove #(every? nil? %))
         (map #(apply + %))
         (apply max)
        )
    ))




