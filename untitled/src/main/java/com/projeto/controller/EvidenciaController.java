package com.projeto.controller;

import com.projeto.entity.Evidencia;
import com.projeto.service.EvidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evidencias")

public class EvidenciaController {

    @Autowired
    private EvidenciaService evidenciaService;

    // CRIAR
    @PostMapping
    public ResponseEntity<Evidencia> salvar(
            @RequestBody Evidencia evidencia) {

        return ResponseEntity.ok(
                evidenciaService.salvar(evidencia)
        );
    }

    // LISTAR TODAS
    @GetMapping
    public ResponseEntity<List<Evidencia>> listarTodos() {

        return ResponseEntity.ok(
                evidenciaService.listarTodos()
        );
    }

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

    //PUT
    @PutMapping("/{id}")
    public Evidencia atualizar(@PathVariable Long id,
                               @RequestBody Evidencia evidencia) {

        return evidenciaService.atualizar(id, evidencia);
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        evidenciaService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}