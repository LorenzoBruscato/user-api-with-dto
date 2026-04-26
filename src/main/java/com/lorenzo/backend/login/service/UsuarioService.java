package com.lorenzo.backend.login.service;

import com.lorenzo.backend.login.dto.UsuarioRequestDto;
import com.lorenzo.backend.login.dto.UsuarioResponseDto;
import com.lorenzo.backend.login.model.Usuario;
import com.lorenzo.backend.login.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Serviço com as regras de negócio para gerenciamento de usuários.
 */
@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    /**
     * Salva um novo usuário no sistema.
     *
     * @param usuario entidade do usuário a ser salva
     * @return usuário salvo com ID gerado
     * @throws RuntimeException se o email já estiver cadastrado
     */
    public Usuario salvar(Usuario usuario) {
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }
        return usuarioRepository.save(usuario);
    }

    /**
     * Atualiza os dados de um usuário existente.
     *
     * @param id  identificador do usuário
     * @param dto novos dados do usuário
     * @return usuário atualizado
     * @throws RuntimeException se o usuário não for encontrado
     */
    public Usuario atualizar(Long id, UsuarioRequestDto dto) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuário não " +
                "encontrado"));

        usuario.setEmail(dto.getEmail());
        usuario.setSenha(dto.getSenha());

        return usuarioRepository.save(usuario);
    }

    /**
     * Remove um usuário pelo ID.
     *
     * @param id identificador do usuário
     * @throws RuntimeException se o usuário não for encontrado
     */
    public void deletar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }
        usuarioRepository.deleteById(id);
    }

    /**
     * Lista todos os usuários cadastrados.
     *
     * @return lista de DTOs com os dados dos usuários
     */
    public List<UsuarioResponseDto> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        usuarioRepository.findAll().forEach(usuarios::add);
        return usuarios.stream().map(UsuarioResponseDto::transformaEmDTO).toList();
    }
}
