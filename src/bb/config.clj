(ns bb.config)

(defn config
  "Default configuration."
  []
  (delay {:db {:host "localhost"
               :port  7474
               :path "db/data/"}}))
