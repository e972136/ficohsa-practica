package com.patito.xmen;

import com.patito.xmen.entity.Candidato;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CandidatoTest {
    @Test
    void candidatoTest01(){
        Candidato candidato = Candidato.of(1,"x",false);
        assertThat(candidato.getId()).isEqualTo(1);
        assertThat(candidato.getDna()).isEqualTo("x");
        assertThat(candidato.getEsMutante()).isEqualTo(false);
    }

    @Test
    void candidatoTest02(){
        Candidato candidato = Candidato.builder().id(1).dna("x").esMutante(false).build();
        assertThat(candidato.getId()).isEqualTo(1);
        assertThat(candidato.getDna()).isEqualTo("x");
        assertThat(candidato.getEsMutante()).isEqualTo(false);
    }
}
