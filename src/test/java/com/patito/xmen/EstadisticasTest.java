package com.patito.xmen;

import com.patito.xmen.dao.Estadisticas;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EstadisticasTest {
    @Test
    void estadisticasTest01(){
        Estadisticas estadisticas = Estadisticas.of(2.0,2.0,0.0);
        assertThat(estadisticas.getRatio()).isEqualTo(0.5);
    }

    @Test
    void estadisticasTest02(){
        Estadisticas estadisticas = new Estadisticas();
        estadisticas.setCount_human_dna(2.0);
        estadisticas.setCount_mutant_dna(2.0);
        assertThat(estadisticas.getRatio()).isEqualTo(0.5);
    }

    @Test
    void estadisticasTest03(){
        Estadisticas estadisticas = new Estadisticas();
        estadisticas.setCount_human_dna(0.0);
        estadisticas.setCount_mutant_dna(0.0);
        assertThat(estadisticas.getRatio()).isEqualTo(0.0);
    }
}
