package com.projeto.controller;

import com.projeto.entity.Usuario;
import com.projeto.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    // CRIAR USUARIO
    @PostMapping
    public ResponseEntity<Usuario> salvar(
            @RequestBody Usuario usuario) {

        return ResponseEntity.ok(
                usuarioService.salvar(usuario)
        );
    }

    // LISTAR TODOS
    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {

        return ResponseEntity.ok(
                usuarioService.listarTodos()
        );
    }

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

    // PUT
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id,
                             @RequestBody Usuario usuario) {

        return usuarioService.atualizar(id, usuario);
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        usuarioService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}