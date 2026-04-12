-- =========================
-- CRIAR BANCO DE DADOS
-- =========================
CREATE DATABASE IF NOT EXISTS login_api;

-- =========================
-- USAR O BANCO
-- =========================
USE login_api;

-- =========================
-- CRIAR TABELA USUARIO
-- =========================
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
('admin@email.com', '123456', true),
('user@email.com', '123456', false);
