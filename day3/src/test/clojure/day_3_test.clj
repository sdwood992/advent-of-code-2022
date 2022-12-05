(ns day-3-test
  (:require [clojure.test :refer :all]
            [day-3 :refer :all]))

(deftest day-3-part-1-test
  (is (= 157 (rucksack-prioritisation "test-input"))))