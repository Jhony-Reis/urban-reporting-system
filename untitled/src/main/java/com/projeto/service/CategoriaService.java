package com.projeto.service;

import com.projeto.entity.Categoria;
import com.projeto.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // SALVAR
    public Categoria salvar(Categoria categoria) {

        return categoriaRepository.save(categoria);
    }

    // LISTAR
    public List<Categoria> listarTodos() {

        return categoriaRepository.findAll();
    }

    // BUSCAR POR ID
    public Categoria buscarPorId(Long id) {

        Optional<Categoria> categoria =
                categoriaRepository.findById(id);

        return categoria.orElse(null);
    }

    public Categoria atualizar(Long id, Categoria categoriaAtualizada) {

        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Categoria não encontrada"));

        categoria.setNome(categoriaAtualizada.getNome());
        categoria.setGravidade(categoriaAtualizada.getGravidade());

        return categoriaRepository.save(categoria);
    }

    // DELETAR
    public void deletar(Long id) {

        categoriaRepository.deleteById(id);
    }
}