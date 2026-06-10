package com.projeto.repository;

import com.projeto.entity.Evidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenciaRepository
        extends JpaRepository<Evidencia, Long> {
}