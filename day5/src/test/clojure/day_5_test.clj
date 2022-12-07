(ns day-5-test
  (:require [clojure.test :refer :all]
            [day-5 :refer :all]))

(deftest day-5-part-1-test
  (is (= "CMZ" (rearrange-stacks-one-at-a-time "test-input"))))

(deftest day-5-part-2-test
  (is (= "MCD" (rearrange-stacks-all-at-once "test-input"))))