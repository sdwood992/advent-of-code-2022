(ns day-3-test
  (:require [clojure.test :refer :all]
            [day-3 :refer :all]))

(deftest day-3-part-1-test
  (is (= 157 (rucksack-prioritisation "test-input"))))

(deftest day-3-part-2-test
  (is (= 70 (rucksack-prioritisation-groups "test-input"))))