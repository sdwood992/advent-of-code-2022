(ns day-4-test
  (:require [clojure.test :refer :all]
            [day-4 :refer :all]))

(deftest simple-test
  (is (= 2 (overalapping-assignments "test-input"))))