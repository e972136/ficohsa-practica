package com.patito.xmen.service;

import com.patito.xmen.dao.CandidatoRequest;
import com.patito.xmen.dao.Estadisticas;
import com.patito.xmen.entity.Candidato;
import com.patito.xmen.entity.Sentinel;
import com.patito.xmen.repository.CandidatoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementacion principal
 * @since  2022/06/22
 * @author GasparCalix
 * */
@Service
@Slf4j
public class CandidatoImp implements CandidatoService{

    private final Sentinel sentinel;
    private final CandidatoRepository repository;

    public CandidatoImp(Sentinel sentinel, CandidatoRepository repository) {
        this.sentinel = sentinel;
        this.repository = repository;
    }


    @Transactional
    @Override
    public Candidato guardar(String dnaArr[],Boolean v) {
        String dna = "";
        for(String r:dnaArr){
            dna+=r+";";
        }
        Candidato bydna = repository.findBydna(dna);
        if(bydna==null){
            log.info("Guardado");
            bydna = repository.save(Candidato.of(null,dna,v));
        }
        return bydna;
    }


    @Override
    public ResponseEntity<CandidatoRequest> validarCandidato(CandidatoRequest candidatoRequest) {

        String[] dnaArr = candidatoRequest.getDna();
        boolean v = sentinel.isMutant(dnaArr);
        Candidato candidato=guardar(dnaArr,v);
        if(v){
            return ResponseEntity.ok(CandidatoRequest.of(candidato.elementos()));
        }
        return  ResponseEntity.status(HttpStatus.FORBIDDEN).body(CandidatoRequest.of(candidato.elementos()));

    }

    @Override
    public ResponseEntity<Estadisticas> estadisticas() {
        Map<Boolean, Long> collect = repository.findAll().stream()
                .collect(Collectors.groupingBy(Candidato::getEsMutante, Collectors.counting()));
//        Map<Boolean, List<Boolean>> collect = repository.findAll().stream().map(r -> r.getEsMutante()).collect(Collectors.groupingBy(r -> r));
//        Map<Boolean, List<Candidato>> collect = repository.findAll().stream().collect(Collectors.groupingBy(r -> r.getEsMutante()));
        if(collect.isEmpty()){
            return ResponseEntity.ok(Estadisticas.of(0.0,0.0,1.0));
        }

        Double esMutante = (double)collect.getOrDefault(true,0L);
        Double noEsMutante = (double)collect.getOrDefault(false,0L);

        Estadisticas of = Estadisticas.of(esMutante,noEsMutante,0.0);
        return ResponseEntity.ok(of);
    }
}
