package com.projeto.controller;

import com.projeto.entity.Denuncia;
import com.projeto.enums.Prioridade;
import com.projeto.enums.StatusDenuncia;
import com.projeto.service.DenunciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/denuncias")
@Tag(
        name = "Denúncias",
        description = "Operações relacionadas às denúncias urbanas"
)

public class DenunciaController {

    @Autowired
    private DenunciaService denunciaService;

    @Operation(summary = "Cadastrar denúncia")
    // CRIAR DENUNCIA
    @PostMapping
    public ResponseEntity<Denuncia> salvar(
            @RequestBody Denuncia denuncia) {

        return ResponseEntity.ok(
                denunciaService.salvar(denuncia)
        );
    }

    @Operation(summary = "Listar denúncias")
    // LISTAR TODAS
    @GetMapping
    public ResponseEntity<List<Denuncia>> listarTodos() {

        return ResponseEntity.ok(
                denunciaService.listarTodos()
        );
    }

    @Operation(summary = "Buscar denúncia por ID")
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

    @Operation(summary = "Buscar denúncias por bairro")
    // BUSCAR POR BAIRRO
    @GetMapping("/bairro/{bairro}")
    public ResponseEntity<List<Denuncia>>
    buscarPorBairro(@PathVariable String bairro) {

        return ResponseEntity.ok(
                denunciaService.buscarPorBairro(bairro)
        );
    }

    @Operation(summary = "Buscar denúncias por status")
    // BUSCAR POR STATUS
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Denuncia>>
    buscarPorStatus(
            @PathVariable StatusDenuncia status) {

        return ResponseEntity.ok(
                denunciaService.buscarPorStatus(status)
        );
    }

    @Operation(summary = "Buscar denúncias por prioridade")
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

    @Operation(summary = "Atualizar denúncia")
    //PUT
    @PutMapping("/{id}")
    public Denuncia atualizar(@PathVariable Long id,
                              @RequestBody Denuncia denuncia) {

        return denunciaService.atualizar(id, denuncia);
    }

    @Operation(summary = "Excluir denúncia")
    // DELETAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        denunciaService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}