package com.projeto.controller;

import com.projeto.entity.Evidencia;
import com.projeto.service.EvidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/evidencias")
@Tag(
        name = "Evidências",
        description = "Gerenciamento das evidências"
)

public class EvidenciaController {

    @Autowired
    private EvidenciaService evidenciaService;

    @Operation(summary = "Cadastrar evidência")
    // CRIAR
    @PostMapping
    public ResponseEntity<Evidencia> salvar(
            @RequestBody Evidencia evidencia) {

        return ResponseEntity.ok(
                evidenciaService.salvar(evidencia)
        );
    }

    @Operation(summary = "Listar evidências")
    // LISTAR TODAS
    @GetMapping
    public ResponseEntity<List<Evidencia>> listarTodos() {

        return ResponseEntity.ok(
                evidenciaService.listarTodos()
        );
    }

    @Operation(summary = "Buscar evidência por ID")
    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Evidencia> buscarPorId(
            @PathVariable Long id) {

        Evidencia evidencia =
                evidenciaService.buscarPorId(id);

        if (evidencia == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(evidencia);
    }

    @Operation(summary = "Atualizar evidência")
    //PUT
    @PutMapping("/{id}")
    public Evidencia atualizar(@PathVariable Long id,
                               @RequestBody Evidencia evidencia) {

        return evidenciaService.atualizar(id, evidencia);
    }

    @Operation(summary = "Excluir evidência")
    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        evidenciaService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}