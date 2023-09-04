(ns starter.browser
  (:require [component.footer :refer [footer]]
            [component.navbar :refer [navbar]]
            [reagent.dom :as rd]))

(defn- app []
  [:div
   [navbar]
   [footer]])

  ;; start is called by init and after code reloading finishes
(defn ^:dev/after-load start []
  (rd/render [app] (js/document.getElementById "app")))

(defn init []
    ;; init is called ONCE when the page loads
    ;; this is called in the index.html and must be exported
    ;; so it is available even in :advanced release builds
  (js/console.log "init")
  (start))

  ;; this is called before any code is reloaded
(defn ^:dev/before-load stop []
  (js/console.log "stop"))