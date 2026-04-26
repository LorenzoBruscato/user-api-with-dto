package com.lorenzo.backend.login.controller;

import com.lorenzo.backend.login.dto.UsuarioRequestDto;
import com.lorenzo.backend.login.dto.UsuarioResponseDto;
import com.lorenzo.backend.login.model.Usuario;
import com.lorenzo.backend.login.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operações de usuários.
 * Endpoints: POST, GET, PUT, DELETE em /usuarios
 */
@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    /**
     * Construtor para injeção de dependência.
     *
     * @param usuarioService serviço de usuários
     */
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Cria um novo usuário.
     *
     * @param dto dados do usuário
     * @return usuário criado com status 201
     */
    @PostMapping
    public ResponseEntity<UsuarioResponseDto> salvar(@RequestBody UsuarioRequestDto dto) {
        Usuario usuario = usuarioService.salvar(dto.transformaParaObjeto());
        return new ResponseEntity<>(UsuarioResponseDto.transformaEmDTO(usuario), HttpStatus.CREATED);
    }

    /**
     * Atualiza um usuário existente.
     *
     * @param id  identificador do usuário
     * @param dto novos dados do usuário
     * @return usuário atualizado com status 200
     */
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> atualizar(@PathVariable Long id, @RequestBody UsuarioRequestDto dto) {
        Usuario usuario = usuarioService.atualizar(id, dto);
        return ResponseEntity.ok(UsuarioResponseDto.transformaEmDTO(usuario));
    }

    /**
     * Remove um usuário pelo ID.
     *
     * @param id identificador do usuário
     * @return status 204 sem conteúdo
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Lista todos os usuários cadastrados.
     *
     * @return lista de usuários com o status 200
     */
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listar() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }
}