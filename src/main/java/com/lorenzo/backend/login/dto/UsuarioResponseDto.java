package com.lorenzo.backend.login.dto;

import com.lorenzo.backend.login.model.Usuario;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class UsuarioResponseDto {

    private Long id;
    private String email;
    private boolean admin;

    public static UsuarioResponseDto transformaEmDTO(Usuario usuario) {
        return new UsuarioResponseDto(usuario.getId(), usuario.getEmail(), usuario.isAdmin());
    }
}
