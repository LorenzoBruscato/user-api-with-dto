package com.lorenzo.backend.login.dto;

import com.lorenzo.backend.login.model.Usuario;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UsuarioRequestDto {

    @NotNull(message = "O email do usuário é obrigatório")
    private String email;

    @NotNull(message = "A senha do usuário é obrigatória")
    private String senha;

    public Usuario transformaParaObjeto() {
        return new Usuario(email, senha);
    }
}