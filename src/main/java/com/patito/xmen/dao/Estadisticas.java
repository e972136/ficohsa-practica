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
        double total = count_mutant_dna/(count_mutant_dna+count_human_dna);
        ratio = BigDecimal.valueOf(total).setScale(3, RoundingMode.CEILING).doubleValue();
        return ratio;
    }
}
