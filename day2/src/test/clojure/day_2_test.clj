(ns day-2-test
  (:require [clojure.test :refer :all]
            [day-2 :refer :all]))

(deftest day-2-part-1-test
  (is (= 15 (strategy-guide-total "test-input"))))