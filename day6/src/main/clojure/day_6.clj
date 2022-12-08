(ns day-6
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(defn read-input [input]
  (-> input
      io/resource
      slurp))

(defn start-of-packet-marker [data-buffer]
  (->> data-buffer
       (partition 4 1)
       (reduce
         (fn [acc buffer-segment]
           (if (= 4 (-> buffer-segment distinct count))
             (reduced (+ acc 4))
             (inc acc)))
         0)))


(defn start-of-packet-marker-from-file [input-file]
  (->> input-file
       read-input
       start-of-packet-marker))



