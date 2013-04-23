(ns bb.neuron
  (:require [clojurewerkz.neocons.rest.nodes :as nn]
            [clojurewerkz.neocons.rest.relationships :as nrl]
            ;; [clj-time.core :as time]
            [clj-time.local :as time]))

(defn create
  "Create a new neuron node. Private fields have to start with underscore. A
  minimal set of keys are required are checked for existance."
  [properties]
  (let [p (assoc properties :cdate (time/now))]
    (nn/create p)))
