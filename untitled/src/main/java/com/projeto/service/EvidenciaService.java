package com.projeto.service;

import com.projeto.entity.Evidencia;
import com.projeto.repository.EvidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EvidenciaService {

    @Autowired
    private EvidenciaRepository evidenciaRepository;

    // SALVAR
    public Evidencia salvar(Evidencia evidencia) {

        return evidenciaRepository.save(evidencia);
    }

    // LISTAR
    public List<Evidencia> listarTodos() {

        return evidenciaRepository.findAll();
    }

    // BUSCAR POR ID
    public Evidencia buscarPorId(Long id) {

        Optional<Evidencia> evidencia =
                evidenciaRepository.findById(id);

        return evidencia.orElse(null);
    }

    //PUT
    public Evidencia atualizar(Long id, Evidencia evidenciaAtualizada) {

        Evidencia evidencia = evidenciaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Evidência não encontrada"));

        evidencia.setUrlImagem(
                evidenciaAtualizada.getUrlImagem()
        );

        evidencia.setDenuncia(
                evidenciaAtualizada.getDenuncia()
        );

        return evidenciaRepository.save(evidencia);
    }

    // DELETAR
    public void deletar(Long id) {

        evidenciaRepository.deleteById(id);
    }
}