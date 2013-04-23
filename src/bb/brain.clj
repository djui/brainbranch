(ns bb.brain
  (:require [bb.config :as config]
            [clojurewerkz.neocons.rest :as nr]))

(defn connect!
  "Connect to database. Currently Neo4j."
  []
  (nr/connect! (config)))

(defn- config
  []
  (let [c (delay (config.config))]
    (format "http://%s:%d/%s"
            c.db.host c.db.port c.db.path)))
