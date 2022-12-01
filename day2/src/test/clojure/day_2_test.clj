(ns day-2-test
  (:require [clojure.test :refer :all]
            [day-2 :refer :all]))

(deftest simple-test
  (is (= "Hello, World!!!" (blah))))