(ns day-6-test
  (:require [clojure.test :refer :all]
            [day-6 :refer :all]))

(deftest day-6-part-1-test

  (is (= 7 (start-of-packet-marker "mjqjpqmgbljsphdztnvjfqwrcgsmlb")))
  (is (= 5 (start-of-packet-marker "bvwbjplbgvbhsrlpgdmjqwftvncz")))
  (is (= 6 (start-of-packet-marker "nppdvjthqldpwncqszvftbrmjlhg")))
  (is (= 10 (start-of-packet-marker "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg")))
  (is (= 11 (start-of-packet-marker "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw")))


  (is (= 7 (start-of-packet-marker-from-file "test-input"))))