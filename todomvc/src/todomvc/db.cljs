(ns todomvc.db
  (:require [cljs.reader]
            [schema.core  :as s :include-macros true]))


;; -- Schema -----------------------------------------------------------------
;;
;; This is a Prismatic Schema which documents the structure of app-db
;; See: https://github.com/Prismatic/schema
;;
;; The value in app-db should ALWAYS match this schema. Now, the value in
;; app-db can ONLY be changed by event handlers so, after each event handler
;; has run, we re-check that app-db still matches this schema.
;;
;; How is this done? Look in handlers.cljs and you'll notice that all handers
;; have an "after" middleware which does the schema re-check.
;;
;; None of this is strictly necessary. It could be omitted. But we find it
;; good practice.

(def TODO-ID s/Int)
(def TODO    {:id TODO-ID :title s/Str :done s/Bool})
(def schema  {:todos    (s/conditional
                          #(instance? PersistentTreeMap %)  ;; is a sorted-map (not just a map)
                          {TODO-ID TODO})                   ;; in this map, each todo is keyed by its :id
              :showing  (s/enum            ;; what todos are shown to the user?
                          :all             ;; all todos are shown
                          :active          ;; only todos whose :done is false
                          :done            ;; only todos whose :done is true
                          )
              :loading? s/Bool})



;; -- Default app-db Value  ---------------------------------------------------
;;
;; When the application first starts, this will be the value put in app-db
;; Unless, or course, there are todos in the LocalStore (see further below)
;; Look in core.cljs for  "(dispatch-sync [:initialise-db])"
;;

(def default-value            ;; what gets put into app-db by default.
  {:todos    (sorted-map)      ;; an empty list of todos. Use the (int) :id as the key
   :showing  :all              ;; show all todos
   :loading? false})
