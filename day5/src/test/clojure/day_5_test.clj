(ns day-5-test
  (:require [clojure.test :refer :all]
            [day-5 :refer :all]))

(deftest day-5-part-1-test
  (is (= "CMZ" (rearrange-stacks "test-input"))))