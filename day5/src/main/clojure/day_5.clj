(ns day-5
  (:require [clojure.java.io :as io]
            [clojure.string :as string]))

(defn- read-input [input]
  (let [[raw-stacks raw-instructions] (->> input
                                   io/resource
                                   slurp
                                   string/split-lines
                                   (partition-by string/blank?)
                                   (remove (partial every? string/blank?)))
        stack-numbers (->> raw-stacks last (re-seq #"[0-9]+"))
        stack-rows (->> raw-stacks
                        butlast
                        (map (fn [raw-stack-row]
                                       (->> raw-stack-row
                                            (partition-all 3 4)
                                            (map-indexed (fn [idx item]
                                                           [(str (inc idx)) (->> item (apply str) string/trim)]))
                                            (remove (comp string/blank? second))
                                            (map (fn [[idx item]]
                                                   [idx (subs item 1 2)]))
                                            (into {})))))]
    {:stacks       (reduce
                     (fn [acc stack-row]
                       (merge-with conj acc stack-row))
                     (zipmap stack-numbers (repeat []))
                     stack-rows)
     :instructions (map (fn [raw-instruction]
                          (let [[[_ num-to-move from to]] (re-seq #"move ([0-9]+) from ([0-9]+) to ([0-9]+)" raw-instruction)]
                            {:number-to-move (parse-long num-to-move)
                             :from           from
                             :to             to})) raw-instructions)}))

(defn rearrange-stacks [input]
  (let [{:keys [stacks instructions]} (read-input input)]
    (->> instructions
         (reduce
           (fn [stack {:keys [number-to-move from to] :as _instruction}]
             (-> stack
                 (update to (partial concat (reverse (take number-to-move (get stack from)))))
                 (update from (partial drop number-to-move))))
           stacks)
         (sort-by key)
         (map (comp first val))
         (apply str))
    ))




