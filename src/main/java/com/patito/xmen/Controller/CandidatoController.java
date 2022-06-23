package com.patito.xmen.Controller;

import com.patito.xmen.dao.CandidatoRequest;
import com.patito.xmen.dao.Estadisticas;
import com.patito.xmen.entity.Candidato;
import com.patito.xmen.service.CandidatoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @since  2022/06/22
 * @author GasparCalix
 * */


@RestController
public class CandidatoController {

    private final CandidatoService candidatoService;

    public CandidatoController(CandidatoService candidatoService) {
        this.candidatoService = candidatoService;
    }

    /**
     * Validacion de Mutantes
     * @param candidatoRequest codigo ADN
     */
    @PostMapping("/mutant")
    @Operation(summary = "Validacion de Mutantes, Debe ingresar cadena DNA", responses = {
            @ApiResponse(responseCode = "200", description = "Es Mutante"),
            @ApiResponse(responseCode = "403", description = "No Es Mutante")
    })
    ResponseEntity<CandidatoRequest> validar(@RequestBody CandidatoRequest candidatoRequest){
        return candidatoService.validarCandidato(candidatoRequest);
    }

    /**
     * Retorno de Estadisticas: count_mutant_dna,count_human_dna,ratio
     * @return Estadisticas calculadas
     */
    @GetMapping("/stats")
    @Operation(summary = "Estadisticas al momento")
    ResponseEntity<Estadisticas> estadisticas(){
        return candidatoService.estadisticas();
    }

}
