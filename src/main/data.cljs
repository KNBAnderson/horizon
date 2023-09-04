(ns data
  (:require [clojure.string :as String]))

(def number-map (array-map 100 "onehundered"
                           90 "ninety"
                           80 "eighty"
                           70 "seventy"
                           60 "sixty"
                           50 "fifty"
                           40 "forty"
                           30 "thirty"
                           20 "twenty"
                           19 "nineteen"
                           18 "eighteen"
                           17 "seventeen"
                           16 "sixteen"
                           15 "fifteen"
                           14 "fourteen"
                           13 "thirteen"
                           12 "twelve"
                           11 "eleven"
                           10 "ten"
                           9 "nine"
                           8 "eight"
                           7 "seven"
                           6 "six"
                           5 "five"
                           4 "four"
                           3 "three"
                           2 "two"
                           1 "one"))

(defn convert-number
  "Takes an integer and converts it to the written out word"
  [n]
  ;; number-map is only set up to translate numbers between 1 and 199 
  (when (< n 200)
    (let [english-number (atom "")
          remaining-number (atom n)]
      (doseq [number number-map]
        (when (>= @remaining-number (key number))
          (swap! remaining-number - (key number))
          (swap! english-number str (val number))))
      @english-number)))

(def written-number
  (apply str
         (map convert-number (range 1 124))))

(def written-number-length
  (count written-number))

(def existing-characters
  (remove #{""} (set (String/split written-number #""))))

(defn char-count
  "Returns how many times a character appears in the written-number variable"
  [ch]
  (count (re-seq (re-pattern ch) written-number)))

(defn emperical-probability
  "Returns the emperical probability based on the number of occurances in a total number"
  [number-of-occurences total]
  (/ number-of-occurences total))

(def emperical-probability-map
  (zipmap existing-characters (map #(emperical-probability (char-count %) written-number-length) existing-characters)))
