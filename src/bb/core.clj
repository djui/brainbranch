(ns bb.core
  (:gen-class)
  (:require [bb.brain :as brain]
            [bb.neuron :as neuron]
            ;; [clj-time.core :as time]
            [clj-time.local :as time]))

(defn -main
  "TODO"
  [& args]
  (brain/connect!)
  (let [n (neuron/create {:who?   :me
                          :what?  :website
                          :when?  (time/to-local-date-time "2013-03-01")
                          :where? "http://erlang.org/doc/apps/erts/erl_dist_protocol.html"
                          :why?   :idea
                          :how?   :google-search})]
    (println n)))
