# API Clojure - Carteira de Investimentos

## Desenvolvedores
Nome: Caio Cruz Alfonso Garcia          RA: 15.01580-7
Nome: Henrique Silva Godoy              RA: 16.01147-3
Nome: Joao Pedro Azevedo 	            RA: 18.02277-4
Nome: Hector Guerrini 		            RA: 15.01310-3

## Resumo
O projeto consiste em criar uma API para inserir, selecionar, atualizar e deletar informações de uma determinada carteira de investimentos. As carteiras de investimentos serão criadas com base no sistema de ARCA (Ativos Nacionais, *Real State*,  Caixa e Ativos Internacionais)

## Desenvolvimento
### Tecnologias

- mySQL DB para armazenamento das informações
- Clojure como linguagem principal

### Informações lógicas do projeto
Serão consideradas essas as entidades principais.

**Pessoas:**
- id: int
- FirstName: string
- LastName: string
- international: string
- Address: string
- City: string

## Rodando o Projeto
Precisa de um MySQL e do lein instalados.

MYSQL:

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

lein: 

lein run

cmd ou qualquer ferramenta de api: 

curl -i http://localhost:9980/queryAll
curl -i http://localhost:9980/ola

## Testes com o projeto

Dentro do projeto, no caminho `./test/rest/` existem diversos arquivos .rest que foram criados com o intuito de testar as chamadas HTTP. 