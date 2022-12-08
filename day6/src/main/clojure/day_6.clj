(ns day-6
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(defn read-input [input]
  (-> input
      io/resource
      slurp))

(defn start-of-packet-marker [data-buffer marker-size]
  (->> data-buffer
       (partition marker-size 1)
       (reduce
         (fn [acc buffer-segment]
           (if (= marker-size (-> buffer-segment distinct count))
             (reduced (+ acc marker-size))
             (inc acc)))
         0)))


(defn start-of-packet-marker-from-file [input-file maker-size]
  (-> input-file
       read-input
       (start-of-packet-marker maker-size) ))



