(ns component.written-number
  (:require [clojure.string :as String]
            [data :refer [emperical-probability-map written-number written-number-length]]
            [reagent.core :as r]
            [semantic-ui-react :as ui]))

(defonce state (r/atom {:error? false
                        :showCard? false
                        :shownChar nil}))

(defn handleClose []
  (swap! state assoc :showCard? false)
  (swap! state assoc :shownChar nil))

(defn handleSubmit [e]
  (let [value (String/lower-case (.. e -target -value))]
    (when (= "Enter" (.-key e))
      ;; The following regex checks that the entered value is only a sinlge character and one of the known letters to the word
      (if-not (re-matches #"^[d|e|f|g|h|i|l|n|o|r|s|t|u|v|w|x|y]$" value)
        (do
          (swap! state assoc :error? true)
          (handleClose))
        (reset! state {:error false :showCard? true :shownChar value})))))

(defn written-number-section []
  [:> ui/Segment {:class ["blue-background" "borderless" "written-number"]}
   [:> ui/Container {:class ["overflow"] :text-align "center"}
    [:> ui/Header {:as "h2"} "Answering the questions"]
    [:> ui/Image {:src "./assets/image-boxes.png"}]
    [:p (str "There are " written-number-length " characters in the word below and it only includes the following letters. Click to find out more")]

    (when (:error? @state)
      [:> ui/Message {:class ["gray"] :content "Please only choose one of the following characters: d, e, f, g, h, i, l, n, o, r, s, t, u, v, w, x, and y"}])

    [:> ui/Grid
     [:> ui/GridRow  {:columns 2}
      [:> ui/GridColumn
       [:> ui/Card {:class "fluid"}
        [:> ui/Button {:class ["yellow" "circular"]}]
        [:> ui/CardContent
         [:> ui/Form
          [:> ui/FormField {:class "inline" :text-align "right"}
           [:> ui/CardHeader "Enter a letter"]
           [:> ui/CardDescription
            [:> ui/Input
             {:type "text"
              :on-key-down #(handleSubmit %)}]]]]]]]

      [:> ui/GridColumn
       (when (:showCard? @state)
         [:> ui/Card {:class "fluid"}
          [:> ui/Button {:class ["yellow" "circular" "mini"] :on-click #(handleClose) :icon "x"}]
          [:> ui/CardContent
           [:> ui/CardHeader "Within the following word..."]
           [:> ui/CardDescription (str "the empirical probability of randomly selecting the  letter '" (:shownChar @state)  "' is " (get emperical-probability-map (:shownChar @state)))]]])]]]

    (map (fn [char]
           [:span {:class [char (when (= (:shownChar @state) char) "emphasize")]} char])
         (remove #{""} (String/split written-number #"")))]])


