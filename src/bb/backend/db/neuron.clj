(ns bb.backend.db.neuron
  (:require [clojurewerkz.neocons.rest.nodes :as nn]
            [clojurewerkz.neocons.rest.relationships :as nrl])
  (:use [clj-time.local :only [local-now to-local-date-time]]
        [clj-time.coerce :only [to-date]]))

(declare prepare)

(defn create
  "Create a new neuron node. Private fields have to start with underscore. A
  minimal set of keys are required are checked for existance."
  [properties]
  (let [n (-> {:cdate (to-date (local-now))}
              (merge properties)
              (prepare))]
    (nn/create n)))

(defn- prepare
  "Sanity check. Checks if well-formed and correct."
  [node]
  (let [default-keys [:who? :what? :when? :where? :why? :how?]]
    (assert (every? (partial contains? node) default-keys)) "Neuron contains not all keys!")
  (update-in node [:when?] (comp to-date to-local-date-time)))
