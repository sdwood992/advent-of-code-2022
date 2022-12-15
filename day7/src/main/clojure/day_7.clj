(ns day-7
  (:require [clojure.java.io :as io]
            [clojure.string :as string]
            [clojure.set :as set]))

(defn command? [line]
  (string/starts-with? line "$"))

(defn directory? [line]
  (string/starts-with? line "dir"))

(defn file? [line]
  (not (or (command? line) (directory? line))))

(defn process-command-line [acc line]
  (let [[[_ command dir]] (re-seq #"\$ (cd) (.+)" line)]
    (case command
      "cd" (if (= dir "..")
             (update acc :current-path (comp vec butlast))
             (update acc :current-path conj dir))
      (do
        (println "current" (:current-path acc))
        acc))))

(defn process-file-line [acc line]
  (let [[[_ file-size file-name]] (re-seq #"([0-9]+) (.*)" line)]
    (update acc :file-system conj {:path (:current-path acc)
                                   :size (parse-long file-size)
                                   :file-name file-name})))

(defn process-directory-line [acc line]
  (let [[[_ directory-name]] (re-seq #"dir (.*)" line)]
    (update acc :file-system conj {:path (:current-path acc)
                                   :size 0
                                   :directory-name directory-name})))

(defn read-input [input]
  (->> input
      io/resource
      slurp
      string/split-lines
      (reduce
        (fn [acc line]
          (cond
            (command? line) (process-command-line acc line)
            (file? line) (process-file-line acc line)
            (directory? line) (process-directory-line acc line)))

        {:current-path []
         :file-system []})
       :file-system))



(defn total-size-of-at-most-100000-directories [input]
  (let [file-system (read-input input)
        directories (->> file-system (map :path) distinct)
        directory->files (reduce (fn [acc directory]
                                  (let [things-in-directory (filter (fn [{:keys [path]}]
                                                                      (let [truncated-path (take (count directory) path)]
                                                                        (= truncated-path directory)))
                                                                    file-system)]
                                    (assoc acc directory things-in-directory)))
                                {}
                                directories)
        directory->sizes (reduce-kv
                           (fn [acc directory-path files]
                             (assoc acc directory-path (transduce (map :size) + 0 files)))
                           {}
                           directory->files)]
    (->> directory->sizes
         (filter #(-> % val (<= 100000)))
         vals
         (reduce +))))