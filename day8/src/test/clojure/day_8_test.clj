(ns day-8-test
  (:require [clojure.test :refer :all]
            [day-8 :refer :all]))

(deftest simple-test
  (is (= 21 (visible-trees "test-input"))))