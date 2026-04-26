package com.lorenzo.backend.login.dto;

import com.lorenzo.backend.login.model.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * DTO de entrada (dados recebidos da requisição).
 */
@Getter
public class UsuarioRequestDto {

    // Email obrigatório
    @NotNull(message = "O email do usuário é obrigatório")
    private String email;

    // Senha obrigatória
    @NotNull(message = "A senha do usuário é obrigatória")
    private String senha;

    /**
     * Converte DTO para entidade Usuario
     */
    public Usuario transformaParaObjeto() {
        return new Usuario(email, senha);
    }
}