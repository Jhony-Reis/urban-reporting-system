package com.projeto.service;

import com.projeto.entity.Denuncia;
import com.projeto.enums.Prioridade;
import com.projeto.enums.StatusDenuncia;
import com.projeto.repository.DenunciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.entity.Categoria;
import com.projeto.repository.CategoriaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DenunciaService {


    @Autowired
    private DenunciaRepository denunciaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    // SALVAR DENUNCIA
    public Denuncia salvar(Denuncia denuncia) {

        definirPrioridade(denuncia);

        denuncia.setStatus(StatusDenuncia.PENDENTE);

        denuncia.setDataCriacao(LocalDateTime.now());

        return denunciaRepository.save(denuncia);
    }

    // LISTAR TODAS
    public List<Denuncia> listarTodos() {

        return denunciaRepository.findAll();
    }

    // BUSCAR POR ID
    public Denuncia buscarPorId(Long id) {

        Optional<Denuncia> denuncia =
                denunciaRepository.findById(id);

        return denuncia.orElse(null);
    }

    //PUT
    public Denuncia atualizar(Long id, Denuncia denunciaAtualizada) {

        Denuncia denuncia = denunciaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Denúncia não encontrada"));

        denuncia.setTitulo(denunciaAtualizada.getTitulo());
        denuncia.setDescricao(denunciaAtualizada.getDescricao());
        denuncia.setBairro(denunciaAtualizada.getBairro());
        denuncia.setStatus(denunciaAtualizada.getStatus());
        denuncia.setPrioridade(denunciaAtualizada.getPrioridade());

        return denunciaRepository.save(denuncia);
    }

    // DELETAR
    public void deletar(Long id) {

        denunciaRepository.deleteById(id);
    }

    // FILTRAR POR BAIRRO
    public List<Denuncia> buscarPorBairro(String bairro) {

        return denunciaRepository.findByBairro(bairro);
    }

    // FILTRAR POR STATUS
    public List<Denuncia> buscarPorStatus(
            StatusDenuncia status) {

        return denunciaRepository.findByStatus(status);
    }

    // FILTRAR POR PRIORIDADE
    public List<Denuncia> buscarPorPrioridade(
            Prioridade prioridade) {

        return denunciaRepository
                .findByPrioridade(prioridade);
    }

    // DEFINIR PRIORIDADE AUTOMATICA
    private void definirPrioridade(Denuncia denuncia) {

        Long categoriaId =
                denuncia.getCategoria().getId();

        Categoria categoria =
                categoriaRepository
                        .findById(categoriaId)
                        .orElse(null);

        if (categoria == null) {

            denuncia.setPrioridade(Prioridade.BAIXA);
            return;
        }

        Integer gravidade = categoria.getGravidade();

        if (gravidade >= 8) {

            denuncia.setPrioridade(Prioridade.ALTA);

        } else if (gravidade >= 5) {

            denuncia.setPrioridade(Prioridade.MEDIA);

        } else {

            denuncia.setPrioridade(Prioridade.BAIXA);
        }

        // IMPORTANTE
        denuncia.setCategoria(categoria);
    }
}