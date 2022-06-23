package com.patito.xmen;

import com.patito.xmen.dao.CandidatoRequest;
import com.patito.xmen.dao.Estadisticas;
import com.patito.xmen.entity.Candidato;
import com.patito.xmen.entity.Sentinel;
import com.patito.xmen.repository.CandidatoRepository;
import com.patito.xmen.service.CandidatoImp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertTrue;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
    @Mock
    CandidatoRepository repository;

    @Mock
    Sentinel sentinel;

    @InjectMocks
    CandidatoImp candidatoImp;

    @Test
    public void testEsMutante(){
        String t5[]= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
        CandidatoRequest candidatoRequest = new CandidatoRequest();
        candidatoRequest.setDna(t5);
        when(sentinel.isMutant(Mockito.any())).thenReturn(true);
        when(repository.findBydna(Mockito.any())).thenReturn(Candidato.of(1,"",true));
        ResponseEntity<CandidatoRequest> response =  candidatoImp.validarCandidato(candidatoRequest);
        assertTrue(response.getStatusCodeValue()==200);
    }

    @Test
    public void testNoEsMutante(){
        String t5[]= {"ATGCGA","CXGTAC","TTAAGT","AGAXGG","XCXCAA","TCACTA"};
        CandidatoRequest candidatoRequest = new CandidatoRequest();
        candidatoRequest.setDna(t5);
        when(sentinel.isMutant(Mockito.any())).thenReturn(false);
        when(repository.findBydna(Mockito.any())).thenReturn(Candidato.of(1,"",false));
        ResponseEntity<CandidatoRequest> response =  candidatoImp.validarCandidato(candidatoRequest);
        assertTrue(response.getStatusCodeValue()==403);
    }

    @Test
    public void testEstadistica(){
        List<Candidato> lista = new ArrayList<>();
        lista.add(Candidato.of(1,"",false));
        lista.add(Candidato.of(2,"",false));
        lista.add(Candidato.of(3,"",true));
        when(repository.findAll()).thenReturn(lista);
        ResponseEntity<Estadisticas> estadisticas = candidatoImp.estadisticas();
        Estadisticas body = estadisticas.getBody();
        Double count_mutant_dna = body.getCount_mutant_dna();
        assertTrue(count_mutant_dna.equals(Double.valueOf(1.0)));
    }
}
