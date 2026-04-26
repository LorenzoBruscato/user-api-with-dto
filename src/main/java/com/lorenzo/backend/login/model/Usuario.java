package com.lorenzo.backend.login.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade que representa um usuário no sistema.
 */
@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    // Identificador único do usuário (chave primária)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Email do usuário (usado para login)
    private String email;

    // Senha do usuário (armazenada de forma criptografada)
    private String senha;

    // Indica se o usuário é administrador
    private boolean admin = false;

    /**
     * Construtor para criação de usuário
     */
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}