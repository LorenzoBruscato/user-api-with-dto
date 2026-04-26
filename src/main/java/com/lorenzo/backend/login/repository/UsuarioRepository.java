package com.lorenzo.backend.login.repository;

import com.lorenzo.backend.login.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Interface responsável pelo acesso aos dados da entidade Usuario.
 */
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    /**
     * Busca um usuário pelo email
     * @param email email do usuário
     * @return Optional contendo o usuário, se encontrado
     */
    Optional<Usuario> findByEmail(String email);
}