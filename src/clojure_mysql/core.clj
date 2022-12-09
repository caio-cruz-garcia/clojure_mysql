(ns clojure-mysql.core
  (:gen-class))

(require '[clojure.java.jdbc :as jdbc])

(let [db-host "localhost"
      db-port 3306
      db-name "ECM969ProgramacaoFuncional"]

(def db {:classname "com.mysql.cj.jdbc.Driver"
         :subprotocol "mysql"
         :subname (str "//" db-host ":" db-port "/" db-name "?useTimezone=true&serverTimezone=UTC")
         :user "root"
         :password "45Mlui26Bwtn"}))

(def resp (jdbc/query db ["SELECT * FROM Persons"]))

(defn -main
  "Codigo clojure para acessar MySql via jdbc"
  [& args]
  (println resp))
