package com.projeto.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.projeto.entity.Categoria;
import com.projeto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@Tag(
        name = "Categorias",
        description = "Gerenciamento das categorias"
)

public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @Operation(summary = "Cadastrar categoria")
    // CRIAR
    @PostMapping
    public ResponseEntity<Categoria> salvar(
            @RequestBody Categoria categoria) {

        return ResponseEntity.ok(
                categoriaService.salvar(categoria)
        );
    }

    @Operation(summary = "Listar categorias")
    // LISTAR TODAS
    @GetMapping
    public ResponseEntity<List<Categoria>> listarTodos() {

        return ResponseEntity.ok(
                categoriaService.listarTodos()
        );
    }

    @Operation(summary = "Buscar categoria por ID")
    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(
            @PathVariable Long id) {

        Categoria categoria =
                categoriaService.buscarPorId(id);

        if (categoria == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(categoria);
    }

    @Operation(summary = "Atualizar categoria")
    // PUT atualiza
    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable Long id,
                               @RequestBody Categoria categoria) {

        return categoriaService.atualizar(id, categoria);
    }

    @Operation(summary = "Excluir categoria")
    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        categoriaService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}