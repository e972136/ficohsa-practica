package com.patito.xmen.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase utilizada para la solicitud y respuestas del DNA
 * @since  2022/06/22
 * @author GasparCalix
 * */
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class CandidatoRequest {
    String dna[];
}
