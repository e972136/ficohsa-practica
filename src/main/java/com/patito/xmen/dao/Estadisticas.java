package com.patito.xmen.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
