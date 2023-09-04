(ns component.footer
  (:require [semantic-ui-react :as ui]))

(defn nav-link [label]
  [:> ui/MenuItem {:class "borderless" :fitted "vertically"}
   label])

(defn footer []
  [:> ui/Menu {:class ["inverted" "footer"]}
   [:> ui/Grid
    [:> ui/GridRow {:columns "1"}
     [:> ui/GridColumn
      [nav-link
       [:> ui/Image {:src "./assets/footerlogo.png" :size "small"}]]
      [:> ui/MenuItem {:class ["header" "borderless"]} "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."]]]
    [:> ui/Divider {:class "inverted"}]
    [:> ui/GridRow {:columns 4}
     [:> ui/GridColumn
      [:> ui/MenuItem {:class ["header" "borderless"]} "SOLUTIONS"]
      [nav-link "Word-Based Numbers Stuff"]
      [nav-link "Consulting"]
      [nav-link "Technology"]
      [:br]
      [:br]
      [:> ui/MenuItem {:class ["header" "borderless"]} "STRATEGIES"]
      [nav-link "Translate Stage"]
      [nav-link "Combine Stage"]
      [nav-link "Filter Stage"]
      [nav-link "Compile Stuff"]]

     [:> ui/GridColumn
      [:> ui/MenuItem {:class ["header" "borderless"]} "COMPANY INFO"]
      [nav-link "Leadership"]
      [nav-link "Sales Team"]
      [nav-link "Our Culture"]
      [:br]
      [:br]
      [:> ui/MenuItem {:class ["header" "borderless"]} "INSIGHTS"]
      [nav-link "Insights Blog"]]

     [:> ui/GridColumn
      [:> ui/MenuItem {:class ["header" "borderless"]} "ADVISOR PLATFORM"]
      [nav-link "Request a Demo"]
      [nav-link "Register/Login"]
      [:br]
      [:br]
      [:> ui/MenuItem {:class ["header" "borderless"]} "LEGAL"]
      [nav-link "FAQS"]
      [nav-link "Terms & Conditions"]
      [nav-link "Privacy Policy"]]

     [:> ui/GridColumn
      [:> ui/MenuItem {:class ["header" "borderless"]} "CONTACT US"]
      [nav-link "Contact Us"]
      [nav-link "Call us at (555) 555-5555"]
      [nav-link "info@randomstatistics.com"]
      [:> ui/MenuItem {:class ["header" "borderless"]} [:div [:> ui/Icon {:name "twitter" :size "large"}] [:> ui/Icon {:name "linkedin" :size "large"}]]]]]
    [:> ui/Divider {:class "inverted"}]
    [:> ui/GridRow {:columns "1"}
     [:> ui/GridColumn
      [nav-link "©2023 Horizon Investments, LLC. All Rights Reserved."]]]]])
