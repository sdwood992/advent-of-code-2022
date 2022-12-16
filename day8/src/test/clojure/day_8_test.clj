(ns day-8-test
  (:require [clojure.test :refer :all]
            [day-8 :refer :all]))

(deftest day-8-part-1-test
  (is (= 21 (visible-trees "test-input"))))

(deftest day-8-part-2-test
  (is (= 8 (scenic-score-trees "test-input"))))