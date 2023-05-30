# Cadastro de Clientes
Este é um projeto de cadastro de clientes que foi desenvolvido utilizando as seguintes tecnologias:

<h3>Backend</h3>

- Java 17: Linguagem de programação utilizada no desenvolvimento do backend do projeto.
- Spring Boot 3.0.8: Framework utilizado para criar aplicações Java rapidamente, fornecendo um ambiente de execução simplificado e facilitando o desenvolvimento do backend.
- Banco de dados PostgreSQL: Sistema de gerenciamento de banco de dados relacional utilizado para armazenar os dados dos clientes.

<h3>Frontend</h3>

- Angular 15.1.6
- NodeJS 18.14

<h3>Instruções de Execução</h3>

Para executar este projeto em sua máquina local, siga as etapas abaixo:

<h3>Pré-requisitos</h3>
Certifique-se de ter as seguintes ferramentas instaladas em seu sistema:

- Java 17
- NodeJS 18.14
- PostgreSQL 15.3

<h3>Configuração do Banco de Dados</h3>

- Crie um banco de dados PostgreSQL em seu sistema com o nome:<h4>maxima-tech-db</h4>.
- Altere as configurações de conexão do banco de dados no arquivo application.properties localizado na pasta /src/main/resources.
- Substitua os valores das propriedades spring.datasource.url, spring.datasource.username e spring.datasource.password com as informações do seu banco de dados.

<h3>Executando o Backend</h3>

- Abra um terminal e navegue até a pasta backend do projeto.
- Execute o seguinte comando para iniciar o servidor backend:

  <h4>./mvnw spring-boot:run</h4>

<h3>Executando o Frontend</h4>

- Abra um novo terminal e navegue até a pasta frontend do projeto.
- Execute os seguintes comandos para instalar as dependências e iniciar o servidor frontend:

  <h4>npm install</h4>
  <h4>ng serve</h4>

Após seguir as etapas acima, o projeto estará em execução. Abra um navegador e acesse http://localhost:4200 para visualizar e interagir com o cadastro de clientes.
