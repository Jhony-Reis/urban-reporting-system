package com.projeto.controller;

import com.projeto.entity.Usuario;
import com.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

@Tag(
        name = "Usuários",
        description = "Operações relacionadas aos usuários"
)

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Operation(summary = "Cadastrar usuário")
    // CRIAR USUARIO
    @PostMapping
    public ResponseEntity<Usuario> salvar(
            @RequestBody Usuario usuario) {

        return ResponseEntity.ok(
                usuarioService.salvar(usuario)
        );
    }

    @Operation(summary = "Listar usuários")
    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {

        return ResponseEntity.ok(
                usuarioService.listarTodos()
        );
    }

    @Operation(summary = "Buscar usuário por ID")
    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(
            @PathVariable Long id) {

        Usuario usuario =
                usuarioService.buscarPorId(id);

        if (usuario == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(usuario);
    }

    @Operation(summary = "Atualizar usuário")
    // PUT
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id,
                             @RequestBody Usuario usuario) {

        return usuarioService.atualizar(id, usuario);
    }

    @Operation(summary = "Excluir usuário")
    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        usuarioService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}