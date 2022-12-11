# API Clojure - Buscando Pessoas da Base

## Desenvolvedores
- Nome: Caio Cruz Alfonso Garcia            RA: 15.01580-7
- Nome: Henrique Silva Godoy                RA: 16.01147-3
- Nome: Joao Pedro Azevedo 	                RA: 18.02277-4
- Nome: Hector Guerrini 		            RA: 15.01310-3

## Resumo
O projeto consiste em criar uma API para selecionar pessoas da base de dados
## Desenvolvimento
### Tecnologias

- MySQL DB para armazenamento das informações
- Clojure como linguagem principal

### Informações lógicas do projeto
Serão consideradas essas as entidades principais.

**Pessoas:**
<br>
- id: int
- FirstName: string
- LastName: string
- Address: string
- City: string
</br>
## Projeto

o projeto consiste em criar um Mysql que pode ser alterado por codigo, na pasta clojure_mysql no arquivo core.clj
onde esta todo a base do MySQL e do Pedestal.

O projeto roda o banco de dados no localhost na porta 3306 com o database "ECM969ProgramacaoFuncional" e possui um acesso de user e password por padrao "root" "45Mlui26Bwtn" respectivamente mas precisa ser alterado para as configurações do seu banco de dados.

## MYSQL
Precisa de um MySQL, lein e pedestal instalados.

CREATE DATABASE ECM969ProgramacaoFuncional;

use ECM969ProgramacaoFuncional;

CREATE TABLE persons (
    id serial PRIMARY KEY,
    FirstName VARCHAR(250) NOT NULL,
    LastName VARCHAR(250) NOT NULL,
    Address VARCHAR(250) NOT NULL,
    City VARCHAR(250) NOT NULL
);

INSERT INTO persons (LastName, FirstName, Address, City)
VALUES ('Exemplo', 'Exemplo', 'Exemplo ','Exemplo')

SELECT * FROM persons;

## lein API's 

lein: 

lein run

cmd ou qualquer ferramenta de api: 

- curl -i http://localhost:9980/queryAll
- curl -i http://localhost:9980/ola

