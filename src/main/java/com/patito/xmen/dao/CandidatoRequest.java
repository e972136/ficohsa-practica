package com.patito.xmen.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Clase utilizada para la solicitud y respuestas del DNA
 * @since  2022/06/22
 * @author GasparCalix
 * */
@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class CandidatoRequest {
    @NotNull
    @NotEmpty
    String dna[];
}
