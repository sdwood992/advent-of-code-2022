(ns day-6-test
  (:require [clojure.test :refer :all]
            [day-6 :refer :all]))

(deftest day-6-part-1-test

  (is (= 7 (start-of-packet-marker "mjqjpqmgbljsphdztnvjfqwrcgsmlb" 4)))
  (is (= 5 (start-of-packet-marker "bvwbjplbgvbhsrlpgdmjqwftvncz" 4)))
  (is (= 6 (start-of-packet-marker "nppdvjthqldpwncqszvftbrmjlhg" 4)))
  (is (= 10 (start-of-packet-marker "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" 4)))
  (is (= 11 (start-of-packet-marker "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" 4)))


  (is (= 7 (start-of-packet-marker-from-file "test-input" 4))))


(deftest day-6-part-2-test

  (is (= 19 (start-of-packet-marker "mjqjpqmgbljsphdztnvjfqwrcgsmlb" 14)))
  (is (= 23 (start-of-packet-marker "bvwbjplbgvbhsrlpgdmjqwftvncz" 14)))
  (is (= 23 (start-of-packet-marker "nppdvjthqldpwncqszvftbrmjlhg" 14)))
  (is (= 29 (start-of-packet-marker "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" 14)))
  (is (= 26 (start-of-packet-marker "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" 14)))


  (is (= 19 (start-of-packet-marker-from-file "test-input" 14))))