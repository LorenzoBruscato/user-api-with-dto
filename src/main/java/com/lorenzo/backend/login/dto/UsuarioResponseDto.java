package com.lorenzo.backend.login.dto;

import com.lorenzo.backend.login.model.Usuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO de resposta (dados que vão para o cliente).
 * Não expõe informações sensíveis como a senha.
 */
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UsuarioResponseDto {

    // ID do usuário
    private Long id;

    // Email do usuário
    private String email;

    // Indica se é administrador
    private boolean admin;

    /**
     * Converte entidade Usuario para DTO
     */
    public static UsuarioResponseDto transformaEmDTO(Usuario usuario) {
        return new UsuarioResponseDto(
                usuario.getId(),
                usuario.getEmail(),
                usuario.isAdmin()
        );
    }
}