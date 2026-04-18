package com.lorenzo.backend.login.repository;

import com.lorenzo.backend.login.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repositório para operações de acesso a dados da entidade {@link Usuario}.
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    /**
     * Busca um usuário pelo e-mail.
     *
     * @param email e-mail do usuário
     * @return Optional contendo o usuário se encontrado, ou vazio caso contrário
     */
    Optional<Usuario> findByEmail(String email);
}