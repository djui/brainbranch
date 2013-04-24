(ns bb.core
  (:gen-class)
  (:require [bb.backend.db.brain :as brain]
            [bb.backend.db.neuron :as neuron])
  (:use [clj-time.local :only [to-local-date-time]]
        [clj-time.coerce :only [to-date]]))

(defn -main
  "TODO"
  [& args]
  (brain/connect!)
  (let [n (neuron/create {:who?   :me
                          :what?  :website
                          :when?  "2013-03-01"
                          :where? "http://erlang.org/doc/apps/erts/erl_dist_protocol.html"
                          :why?   :idea
                          :how?   :google-search})]
    (println n)))
