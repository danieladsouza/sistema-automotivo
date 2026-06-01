# 🚗 Sistema de Estoque Automotivo

Projeto desenvolvido com **Java + Spring Boot**, com foco em gerenciamento de veículos e marcas em um sistema de estoque automotivo.

## 📌 Sobre o projeto

Este sistema tem como objetivo gerenciar um estoque de veículos, permitindo o cadastro, consulta, atualização e remoção de registros de **veículos e marcas**.

A aplicação segue uma arquitetura em camadas, utilizando boas práticas de desenvolvimento com Spring Boot.

---

## ⚙️ Tecnologias utilizadas

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven

---

## 🧱 Estrutura do projeto

controller → camada responsável pelos endpoints da API
service → regras de negócio
repository → comunicação com o banco de dados
entity → modelos do sistema (Marca e Veículo)

## 📬 Exemplos de requisições (Postman)

## ➕ POST - Criar veículo
```json
POST /veiculos
{
  "modelo": "Civic",
  "preco": 120000,
  "status": "Disponível",
  "cor": "branco",
}
```

## 📥 GET - Listar veículos
GET /veiculos

## ✏️ PATCH - Atualizar veículo
PATCH /veiculos/1
```json{
  "preco": 110000
}
```

## ❌ DELETE - Remover veículo
DELETE /veiculos/1

## 🗄️ Banco de dados (MySQL)

O sistema utiliza MySQL para persistência de dados.

Estrutura básica:
-tabela marca
-tabela veiculo

Relacionamento:

Uma marca pode ter vários veículos (One-to-Many)
▶️ Como executar o projeto
Clonar o repositório
git clone <url-do-repositorio>
Configurar o banco MySQL no application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/estoque_automotivo
spring.datasource.username=root
spring.datasource.password=senha
Rodar a aplicação
mvn spring-boot:run
