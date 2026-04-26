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
 * Controller responsável pelos endpoints de usuários.
 */
@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

    // Service com regras de negócio
    private final UsuarioService usuarioService;

    // Injeção de dependência via construtor
    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Cria um novo usuário
     */
    @PostMapping
    public ResponseEntity<UsuarioResponseDto> salvar(@RequestBody UsuarioRequestDto dto) {
        Usuario usuario = usuarioService.salvar(dto.transformaParaObjeto());

        // Retorna 201 Created com o usuário criado
        return new ResponseEntity<>(
                UsuarioResponseDto.transformaEmDTO(usuario),
                HttpStatus.CREATED
        );
    }

    /**
     * Remove um usuário pelo ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);

        // Retorna 204 No Content
        return ResponseEntity.noContent().build();
    }

    /**
     * Atualiza um usuário existente
     */
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> atualizar(
            @PathVariable Long id,
            @RequestBody UsuarioRequestDto dto) {

        Usuario usuario = usuarioService.atualizar(id, dto);

        // Retorna 200 OK com os dados atualizados
        return ResponseEntity.ok(
                UsuarioResponseDto.transformaEmDTO(usuario)
        );
    }

    /**
     * Lista todos os usuários
     */
    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listar() {

        return ResponseEntity.ok(
                usuarioService.listarUsuarios()
        );
    }
}