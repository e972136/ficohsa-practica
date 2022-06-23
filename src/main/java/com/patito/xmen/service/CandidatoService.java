package com.patito.xmen.service;

import com.patito.xmen.dao.CandidatoRequest;
import com.patito.xmen.dao.Estadisticas;
import com.patito.xmen.entity.Candidato;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;


public interface CandidatoService {

    /**
     * Almacena el ADN del individuo
     * @param dna,v
     * @return  Candidato ya sea nuevo o el de la bd
     */
    @Transactional
    Candidato guardar(String dna[],Boolean v);

    /**
     * Validacion de Mutantes
     * @param candidatoRequest
     */
    ResponseEntity<CandidatoRequest> validarCandidato(CandidatoRequest candidatoRequest);

    /**
     * Determinacion de estadisticas
     * @return retorna las estadisticas
     */
    ResponseEntity<Estadisticas> estadisticas();
}
