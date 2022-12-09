(ns clojure-mysql.core
  (:gen-class)
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [clojure.data.json :as json]
            [clojure.java.jdbc :as jdbc]))


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

(defn insertDB [request] (jdbc/insert! db :Persons request))

(defn insertFunc [request] [(insertDB request)(json/write-str queryAllDB)])

(defn queryAll [request]
  {:status 200 :body (json/write-str queryAllDB)})

(defn insert [request]
  {:status 200 :body (insertFunc (json/read-str request))})

(def routes
  (route/expand-routes
   #{["/ola" :get response-hello :route-name :ola]
     ["/queryAll" :get queryAll :route-name :queryAll]
     ["/insert" :post insert :route-name :insert]}
 ))
 


(defn server []
  (http/create-server
   {::http/routes routes
    ::http/type :jetty
    ::http/port 9995}))




(defn start []
  (http/start (server)))
(defn stop []
  (http/stop (server)))

(start)

(stop)