package com.lorenzo.backend.login.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Entidade que representa um usuário do sistema.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Usuario {

    /**
     *  ID único do usuário.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * E-mail do usuário (único).
     */
    private String email;

    /**
     * Senha do usuário.
     */
    private String senha;

    /**
     * Indica se o usuário possui permissões de administrador.
     * Padrão: false.
     */
    private boolean admin = false;

    /**
     * Construtor para criação de um novo usuário.
     *
     * @param email e-mail do usuário
     * @param senha senha do usuário
     */
    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
    }
}