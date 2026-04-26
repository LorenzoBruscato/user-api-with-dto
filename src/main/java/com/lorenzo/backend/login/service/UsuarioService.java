package com.lorenzo.backend.login.service;

import com.lorenzo.backend.login.dto.UsuarioRequestDto;
import com.lorenzo.backend.login.dto.UsuarioResponseDto;
import com.lorenzo.backend.login.model.Usuario;
import com.lorenzo.backend.login.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Serviço responsável pelas regras de negócio relacionadas ao usuário.
 */
@Service
@AllArgsConstructor
public class UsuarioService {

    // Repositório para acesso ao banco de dados
    private final UsuarioRepository usuarioRepository;

    // Responsável por criptografar a senha
    private final PasswordEncoder passwordEncoder;

    /**
     * Salva um novo usuário no sistema
     */
    public Usuario salvar(Usuario usuario) {
        // Verifica se o email já está cadastrado
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        // Criptografa a senha antes de salvar
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);

        return usuarioRepository.save(usuario);
    }

    /**
     * Atualiza os dados de um usuário existente
     */
    public Usuario atualizar(Long id, UsuarioRequestDto dto) {
        // Busca usuário pelo ID
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        // Validação de senha
        if (dto.getSenha() == null || dto.getSenha().trim().isEmpty()) {
            throw new RuntimeException("Senha não pode ser vazia ou nula");
        }

        // Validação de email
        if (dto.getEmail() == null || dto.getEmail().trim().isEmpty()) {
            throw new RuntimeException("Email não pode ser vazio ou nulo");
        }

        // Atualiza dados
        usuario.setEmail(dto.getEmail());

        // Criptografa a nova senha
        String senhaCriptografada = passwordEncoder.encode(dto.getSenha());
        usuario.setSenha(senhaCriptografada);

        return usuarioRepository.save(usuario);
    }

    /**
     * Remove um usuário pelo ID
     */
    public void deletar(Long id) {
        // Verifica se o usuário existe
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuário não encontrado");
        }

        usuarioRepository.deleteById(id);
    }

    /**
     * Lista todos os usuários convertendo para DTO
     */
    public List<UsuarioResponseDto> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        // Busca todos os usuários do banco
        usuarioRepository.findAll().forEach(usuarios::add);

        // Converte para DTO antes de retornar
        return usuarios.stream()
                .map(UsuarioResponseDto::transformaEmDTO)
                .toList();
    }
}