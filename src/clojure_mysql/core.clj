(ns clojure-mysql.core
  (:gen-class)
  (:require [clojure.data.json :as json]
            [clojure.java.jdbc :as jdbc]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            ))

(require '[clojure.java.jdbc :as jdbc])

(let [db-host "localhost"
      db-port 3306
      db-name "ECM969ProgramacaoFuncional"]

(def db {:classname "com.mysql.cj.jdbc.Driver"
         :subprotocol "mysql"
         :subname (str "//" db-host ":" db-port "/" db-name "?useTimezone=true&serverTimezone=UTC")
         :user "root"
         :password "45Mlui26Bwtn"}))

(defn response-hello [request]
  {:status 200 :body "Hello Pedestal..."})

(def queryAllDB (jdbc/query db ["SELECT * FROM Persons"]))

(defn queryAll [request]
  {:status 200 :body (json/write-str queryAllDB)}) 

(def routes
  (route/expand-routes
   #{["/ola" :get response-hello :route-name :ola]
     ["/queryAll" :get queryAll :route-name :queryAll]}
 )) 

(defn server []
  (http/create-server
   {::http/routes routes
    ::http/type :jetty
    ::http/port 9980}))

(defn start []
  (http/start (server)))
(defn stop []
  (http/stop (server)))

(start)

(stop)