(ns day-7-test
  (:require [clojure.test :refer :all]
            [day-7 :refer :all]))

(deftest day-7-part-1-test
  (is (= 95437 (total-size-of-at-most-100000-directories "test-input"))))


(deftest day-7-part-2-test
  (is (= 24933642 (total-size-of-at-most-100000-directories "test-input"))))