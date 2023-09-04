(ns data-test
  (:require
   [cljs.test :refer-macros [deftest is testing]]
   [data :as data]))

(deftest test-convert-number-function
  (testing "converts a number to its corresponding written-out word"
    (is (= (data/convert-number 1) "one"))
    (is (= (data/convert-number 12) "twelve"))
    (is (= (data/convert-number 200) "onehundredninetynine"))))

(deftest test-written-number
  (testing "creates a string containing the written-out numbers from 1 to 123"
    (is (= (data/written-number) "onetwothreefourfivesixseveneightnineteneleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteentwentytwentyonetwentytwotwentythreetwentyfourtwentyfivetwentysixtwentyseventwentyeighttwentyninethirtythirtyonethirtytwothirtythreethirtyfourthirtyfivethirtysixthirtyseventhirtyeightthirtyninefortyfortyonefortytwofortythreefortyfourfortyfivefortysixfortysevenfortyeightfortyninefiftyfiftyonefiftytwofiftythreefiftyfourfiftyfivefiftysixfiftysevenfiftyeightfiftyninesixtysixtyonesixtytwosixtythreesixtyfoursixtyfivesixtysixsixtysevensixtyeightsixtynineseventyseventyoneseventytwoseventythreeseventyfourseventyfiveseventysixseventysevenseventyeightseventynineeightyeightyoneeightytwoeightythreeeightyfoureightyfiveeightysixeightyseveneightyeighteightynineninetyninetyoneninetytwoninetythreeninetyfourninetyfiveninetysixninetysevenninetyeightninetynineonehunderedonehunderedoneonehunderedtwoonehunderedthreeonehunderedfouronehunderedfiveonehunderedsixonehunderedsevenonehunderedeightonehunderednineonehunderedtenonehunderedelevenonehunderedtwelveonehunderedthirteenonehunderedfourteenonehunderedfifteenonehunderedsixteenonehunderedseventeenonehunderedeighteenonehunderednineteenonehunderedtwentyonehunderedtwentyoneonehunderedtwentytwoonehunderedtwentythree"))))

(deftest test-written-number-length
  (testing "returns the length of the written-number string"
    (is (= (data/written-number-length) 1259))))

(deftest test-existing-characters
  (testing "returns a set of the unique characters in the written-number string"
    (is (= (data/existing-characters) #{"d" "e" "f" "g" "h" "i" "l" "n" "o" "r" "s" "t" "u" "v" "w" "x" "y"}))))

(deftest test-char-count
  (testing "returns the number of times a character appears in the written-number string"
    (is (= (data/char-count "d") 48))
    (is (= (data/char-count "n") 157))
    (is (= (data/char-count "t") 160))))

(deftest test-emperical-probability
  (testing "returns the decimal solution of dividing a number of specific occurances by a total number"
    (is (= (data/emperical-probability 2 10) 0.2))
    (is (= (data/emperical-probability 3 12) 0.25))))

(deftest test-emperical-probability
  (testing "returns a map of the empirical probability of different known characters appearing in the written-number string"
    (is (= (get data/emperical-probability "f") 0.04447974583002383))
    (is (= (get data/emperical-probability "x") 0.017474185861795076))))
