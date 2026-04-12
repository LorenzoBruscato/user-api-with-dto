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

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponseDto> salvar(@RequestBody UsuarioRequestDto dto) {
        Usuario usuario = usuarioService.salvar(dto.transformaParaObjeto());
        return new ResponseEntity<>(UsuarioResponseDto.transformaEmDTO(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> atualizar(@PathVariable Long id,
                                                        @RequestBody UsuarioRequestDto dto) {
        Usuario usuario = usuarioService.atualizar(id, dto);
        return ResponseEntity.ok(UsuarioResponseDto.transformaEmDTO(usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDto>> listar() {
        return ResponseEntity.ok(usuarioService.listarUsuarios());
    }
}