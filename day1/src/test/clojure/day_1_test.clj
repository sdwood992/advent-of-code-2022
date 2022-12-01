(ns day-1-test
  (:require [clojure.test :refer :all]
            [day-1 :refer :all]))

(deftest day-1-part-1-test
  (is (= 24000 (most-calories-carried-by-an-elf "test-input"))))

(deftest day-1-part-2-test
  (is (= 45000 (calories-carried-by-the-top-3-elves "test-input"))))