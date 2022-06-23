package com.patito.xmen.repository;

import com.patito.xmen.entity.Candidato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
    Candidato findBydna(String dna);
}
