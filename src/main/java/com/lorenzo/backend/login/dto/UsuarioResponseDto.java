package com.lorenzo.backend.login.dto;

import com.lorenzo.backend.login.model.Usuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO para resposta das operações com usuários.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UsuarioResponseDto {

    /**
     * Identificador único do usuário.
     */
    private Long id;

    /**
     * E-mail do usuário.
     */
    private String email;

    /**
     * Indica se o usuário possui permissões de administrador.
     */
    private boolean admin;

    /**
     * Converte um objeto {@link Usuario} para DTO de resposta.
     *
     * @param usuario entidade do usuário
     * @return DTO com os dados do usuário
     */
    public static UsuarioResponseDto transformaEmDTO(Usuario usuario) {
        return new UsuarioResponseDto(usuario.getId(), usuario.getEmail(), usuario.isAdmin());
    }
}