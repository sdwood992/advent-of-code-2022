(ns day-1-test
  (:require [clojure.test :refer :all]
            [day-1 :refer :all]))

(deftest simple-test
  (is (= "Hello, World!!!" (blah))))