(ns day-2-test
  (:require [clojure.test :refer :all]
            [day-2 :refer :all]))

(deftest day-2-part-1-test
  (is (= 15 (strategy-guide-assumed-total "test-input"))))

(deftest day-2-part-2-test
  (is (= 12 (strategy-guide-correct-total "test-input"))))