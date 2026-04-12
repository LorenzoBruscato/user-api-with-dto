package com.lorenzo.backend.login.service;

import com.lorenzo.backend.login.dto.UsuarioRequestDto;
import com.lorenzo.backend.login.dto.UsuarioResponseDto;
import com.lorenzo.backend.login.model.Usuario;
import com.lorenzo.backend.login.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    public Usuario salvar(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }
        return usuarioRepository.save(usuario);
    }

    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    public Usuario atualizar(Long id, UsuarioRequestDto dto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não " +
                "encontrado"));

        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        return usuarioRepository.save(usuario);
    }

    public List<UsuarioResponseDto> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuarios::add);
        return usuarios.stream()
                .map(UsuarioResponseDto::transformaEmDTO)
                .toList();
    }
}
