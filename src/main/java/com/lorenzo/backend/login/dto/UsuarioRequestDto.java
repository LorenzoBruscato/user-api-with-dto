package com.lorenzo.backend.login.dto;

import com.lorenzo.backend.login.model.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * DTO para requisições de usuários.
 * Contém os dados de entrada: email e senha.
 */
@Getter
public class UsuarioRequestDto {

    /**
     * E-mail do usuário.
     */
    @NotNull(message = "O email do usuário é obrigatório")
    private String email;

    /**
     * Senha do usuário.
     */
    @NotNull(message = "A senha do usuário é obrigatória")
    private String senha;

    /**
     * Converte o DTO para a entidade {@link Usuario}.
     *
     * @return entidade Usuario com os dados do DTO
     */
    public Usuario transformaParaObjeto() {
        return new Usuario(email, senha);
    }
}