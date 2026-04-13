# 🔐 Backend Login API

API REST desenvolvida com **Spring Boot** para gerenciamento de usuários, com funcionalidades de cadastro, listagem, atualização e remoção.

---

## 🚀 Tecnologias utilizadas

* Java 21
* Spring Boot
* Spring Data JPA
* MySQL
* Lombok
* Maven

---

## 📂 Estrutura do projeto

```
src/main/java/com/lorenzo/backend/login
│
├── controller   # Endpoints da API
├── service      # Regras de negócio
├── repository   # Acesso ao banco de dados
├── model        # Entidades
├── dto          # Transferência de dados
```

---

## 🗄️ Banco de dados

Banco utilizado: **MySQL**

### Script SQL:

```sql
CREATE DATABASE IF NOT EXISTS login_api;
USE login_api;

CREATE TABLE IF NOT EXISTS usuario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    admin BOOLEAN NOT NULL DEFAULT FALSE
);

-- =========================
-- INSERIR DADOS DE TESTE
-- =========================
INSERT INTO usuario (email, senha, admin) VALUES
('admin@email.com', '123456', TRUE),
('user@email.com', '123456', FALSE);

```

---

## ⚙️ Configuração

Arquivo `application.properties`:

```properties
spring.application.name=backend-login

# Data Source
spring.datasource.url=jdbc:mysql://localhost:3306/login_api
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}

# JPA
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 📮 Endpoints

### 🔹 Criar usuário

* **POST** `/usuarios`

```json
{
  "email": "teste@email.com",
  "senha": "123456"
}
```

---

### 🔹 Listar usuários

* **GET** `/usuarios`

---

### 🔹 Atualizar usuário

* **PUT** `/usuarios/{id}`

```json
{
  "email": "novo@email.com",
  "senha": "123456"
}
```

---

### 🔹 Deletar usuário

* **DELETE** `/usuarios/{id}`

---

## 🧪 Testes

A API pode ser testada utilizando:

* Postman
* Insomnia

---

## ⚠️ Observações

* Senhas estão sendo armazenadas em texto simples (não recomendado para produção)
* O campo `admin` possui valor padrão `false`
* O projeto foi desenvolvido com fins de estudo

---

## 🔥 Melhorias futuras

* 🔐 Criptografia de senha (BCrypt)
* 🔑 Autenticação com JWT
* 🧾 Tratamento de exceções global

---

## 👨‍💻 Autor

Desenvolvido por **Lorenzo Bruscato**

---

## 📚 Referências

Este projeto foi desenvolvido com base em estudos sobre boas práticas em APIs REST com Spring Boot, incluindo o uso do padrão DTO.

- https://marioalvial.medium.com/blindando-sua-api-spring-boot-com-o-padr%C3%A3o-dto-44f97020d1a0
