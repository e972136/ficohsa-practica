package com.patito.xmen;

import com.patito.xmen.dao.CandidatoRequest;
import com.patito.xmen.service.CandidatoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;


//@RunWith(SpringJUnit4ClassRunner.class)
//@DataJpaTest
//@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
//@TestPropertySource("/test.properties")
public class EstadisticaTest {

//    @Autowired
//    private CandidatoService candidatoService;
//
//    @Test
//    public void EstadisticaTest1(){
//        String t5[]= {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
//        CandidatoRequest candidatoRequest= CandidatoRequest.of(t5);
//        ResponseEntity<CandidatoRequest> candidatoRequestResponseEntity = candidatoService.validarCandidato(candidatoRequest);
//        HttpStatus statusCode = candidatoRequestResponseEntity.getStatusCode();
//        assertThat(statusCode).isEqualTo(HttpStatus.OK);
////        ResponseEntity<Estadisticas> estadisticas = candidatoService.estadisticas();
////        Estadisticas body = estadisticas.getBody();
////        System.err.println(body);
//    }
}
