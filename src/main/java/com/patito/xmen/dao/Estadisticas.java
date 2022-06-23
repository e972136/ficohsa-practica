package com.patito.xmen.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Clase utilizada para determinar las estadisticas
 * @since  2022/06/22
 * @author GasparCalix
 * */
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class Estadisticas {
    Double count_mutant_dna;
    Double count_human_dna;
    Double ratio;

    public Double getRatio() {
        double suma = (count_mutant_dna+count_human_dna);
        if(suma==0){
            return 0.0;
        }
        double total = count_mutant_dna/suma;
        ratio = BigDecimal.valueOf(total).setScale(3, RoundingMode.CEILING).doubleValue();
        return ratio;
    }
}
