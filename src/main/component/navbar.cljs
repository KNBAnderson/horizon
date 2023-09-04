(ns component.navbar
  (:require [semantic-ui-react :as ui]))

(defn nav-link [label]
  [:> ui/MenuItem {:class "borderless"  :fitted "vertically"}
   label])

(defn nav-button [label class]
  [:> ui/MenuItem {:class "borderless" :fitted "vertically"}
   [:> ui/Button {:class class}
    label]])

(defn navbar  []
  [:> ui/Menu
   [:> ui/MenuItem [:> ui/Image {:src "./assets/RANDOM_STATISTICS.png" :size "small"}]]
   [:> ui/MenuMenu {:position "right"}
    [nav-link "SOLUTIONS"]
    [nav-link "STATEGIES"]
    [nav-link "INSIGHTS"]
    [nav-link "OUR PEOPLE"]
    [nav-button "Login" ["circular" "black" "basic"]]
    [nav-button "Contact Us" ["yellow" "circular"]]]])
