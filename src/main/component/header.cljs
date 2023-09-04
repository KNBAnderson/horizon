(ns component.header
  (:require [semantic-ui-react :as ui]))

(defn header []
  [:> ui/Segment {:class ["hero" "basic"]}
   [:> ui/Header {:text-align "center" :as "h1"}
    "Empower this programmer"]
   [:> ui/Container {:text-align "center"} "If you are looking for the probabilites of a highly specific, and not at all useful scenario, Random Statistics is the answer. Have you ever wondered what the numbers 1 - 123 would look like, spelled out, with no spaces? Are you dying to know how long that word is? Does it keep you up at night, contemplating the empiriocal probability of 'e' being randomly selected? What about the other letters?!"]
   [:br]
   [:> ui/Grid
    [:> ui/GridRow {:columns 2}
     [:> ui/GridColumn
      [:> ui/Button {:class ["yellow" "circular"] :floated "right"}
       "Scroll Down"]]
     [:> ui/GridColumn
      [:> ui/Button {:class ["black" "circular"]}
       "To Learn More"]]]]])