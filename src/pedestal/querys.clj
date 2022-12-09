(ns pedestal.querys
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]))

(defn response-hello [request]
  {:status 200 :body "Hello Pedestal..."})

(def routes
  (route/expand-routes
   #{["/ola" :get response-hello :route-name :ola]}))

(defn server []
  (http/create-server
   {::http/routes routes
    ::http/type :jetty
    ::http/port 8899}))

(defn start []
  (http/start (server)))

(defn stop []
  (http/stop (server)))


