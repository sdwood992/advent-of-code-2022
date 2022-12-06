(ns day-4-test
  (:require [clojure.test :refer :all]
            [day-4 :refer :all]))

(deftest day-4-part-1
  (is (= 2 (complete-overalapping-assignments "test-input"))))

(deftest day-4-part-2
  (is (= 4 (any-overalapping-assignments "test-input"))))