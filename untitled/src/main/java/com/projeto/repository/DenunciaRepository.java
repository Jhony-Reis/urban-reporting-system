package com.projeto.repository;

import com.projeto.entity.Denuncia;
import com.projeto.enums.Prioridade;
import com.projeto.enums.StatusDenuncia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DenunciaRepository
        extends JpaRepository<Denuncia, Long> {

    List<Denuncia> findByBairro(String bairro);

    List<Denuncia> findByStatus(StatusDenuncia status);

    List<Denuncia> findByPrioridade(Prioridade prioridade);

}