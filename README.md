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
├── config       # Configurações da aplicação (segurança, beans)
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

* 📌 Não é possível criar usuário administrador via API no momento (apenas via banco)
* 📌 Recomenda-se criar usuários via API para garantir que a senha seja armazenada corretamente com criptografia.

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

* **Http:** `http://localhost:8080/usuarios`

* **Body:**
```json
{
  "email": "novo@email.com",
  "senha": "123456"
}
```

* **Resposta (201 Created):**
```json
{
    "admin": false,
    "email": "novo@email.com",
    "id": 3
}
```
---

### 🔹 Atualizar usuário

* **PUT** `/usuarios/{id}`

* **Htpp** `http://localhost:8080/usuarios/1`

* **Body:**
```json
{
  "email": "adm2@email.com",
  "senha": "123456"
}
```

* **Resposta (200 OK):**
```json
{
    "admin": true,
    "email": "adm2@email.com",
    "id": 1
}
```

---

### 🔹 Deletar usuário

* **DELETE** `/usuarios/{id}`

* **Htpp** `http://localhost:8080/usuarios/1`

* **Resposta (204 No Content):**

---

### 🔹 Listar usuários

* **GET** `/usuarios`

* **Htpp** `http://localhost:8080/usuarios`

* **Resposta (200 Ok):**
```json
{
    {
        "admin": false,
        "email": "user@email.com",
        "id": 2
    },
    {
        "admin": false,
        "email": "novo@email.com",
        "id": 3
    }
```

* **📌 Lembre-se:** aqui o usuario ``adm2@email.com`` não aparece, ele foi apagado quando deletamos o usuário com o id 1

---

## 🔐 Segurança

A API utiliza:

* Criptografia de senha com BCrypt
* Spring Security para controle de acesso
* Configuração de endpoints públicos e protegidos

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

## 🔥 Lista de Melhorias

* 🔐 Criptografia de senha com BCrypt ✅ (implementado)
* 🔑 Autenticação e autorização com JWT ⏳ (em desenvolvimento)
* 🧾 Tratamento global de exceções⏳

---

## 👨‍💻 Autor

Desenvolvido por **Lorenzo Bruscato**

---

## 📚 Referências

Este projeto foi desenvolvido com base em estudos sobre boas práticas em APIs REST com Spring Boot, incluindo o uso do padrão DTO.

- https://marioalvial.medium.com/blindando-sua-api-spring-boot-com-o-padr%C3%A3o-dto-44f97020d1a0
