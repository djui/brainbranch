(ns bb.backend.db.brain
  (:require [bb.config :as config]
            [clojurewerkz.neocons.rest :as nr])
  (:use [clojure.tools.logging :as log]))

(declare config)

(defn connect!
  "Connect to database. Currently Neo4j."
  []
  (try (nr/connect! (config))
    (catch java.net.ConnectException e
      (log/error e "Neo4j not running?")
      (throw e))))

(defn- config
  []
  (let [c @(config/config)]
    (format "http://%s:%d/%s"
            (get-in c [:db :host])
            (get-in c [:db :port])
            (get-in c [:db :path]))))
