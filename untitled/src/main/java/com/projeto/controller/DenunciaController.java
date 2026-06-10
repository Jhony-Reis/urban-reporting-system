package com.projeto.controller;

import com.projeto.entity.Denuncia;
import com.projeto.enums.Prioridade;
import com.projeto.enums.StatusDenuncia;
import com.projeto.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/denuncias")

public class DenunciaController {

    @Autowired
    private DenunciaService denunciaService;

    // CRIAR DENUNCIA
    @PostMapping
    public ResponseEntity<Denuncia> salvar(
            @RequestBody Denuncia denuncia) {

        return ResponseEntity.ok(
                denunciaService.salvar(denuncia)
        );
    }

    // LISTAR TODAS
    @GetMapping
    public ResponseEntity<List<Denuncia>> listarTodos() {

        return ResponseEntity.ok(
                denunciaService.listarTodos()
        );
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Denuncia> buscarPorId(
            @PathVariable Long id) {

        Denuncia denuncia =
                denunciaService.buscarPorId(id);

        if (denuncia == null) {

            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(denuncia);
    }

    // BUSCAR POR BAIRRO
    @GetMapping("/bairro/{bairro}")
    public ResponseEntity<List<Denuncia>>
    buscarPorBairro(@PathVariable String bairro) {

        return ResponseEntity.ok(
                denunciaService.buscarPorBairro(bairro)
        );
    }

    // BUSCAR POR STATUS
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Denuncia>>
    buscarPorStatus(
            @PathVariable StatusDenuncia status) {

        return ResponseEntity.ok(
                denunciaService.buscarPorStatus(status)
        );
    }

    // BUSCAR POR PRIORIDADE
    @GetMapping("/prioridade/{prioridade}")
    public ResponseEntity<List<Denuncia>>
    buscarPorPrioridade(
            @PathVariable Prioridade prioridade) {

        return ResponseEntity.ok(
                denunciaService
                        .buscarPorPrioridade(prioridade)
        );
    }


    //PUT
    @PutMapping("/{id}")
    public Denuncia atualizar(@PathVariable Long id,
                              @RequestBody Denuncia denuncia) {

        return denunciaService.atualizar(id, denuncia);
    }

    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        denunciaService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}