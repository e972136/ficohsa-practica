package com.patito.xmen.Controller;

import com.patito.xmen.dao.CandidatoRequest;
import com.patito.xmen.dao.Estadisticas;
import com.patito.xmen.entity.Candidato;
import com.patito.xmen.service.CandidatoService;
import com.patito.xmen.util.ManejoValidaciones;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.stream.Collectors;

/**
 * @since  2022/06/22
 * @author GasparCalix
 * */


@RestController
@Slf4j
public class CandidatoController implements ManejoValidaciones {

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
    ResponseEntity<CandidatoRequest> validar(@Valid @RequestBody CandidatoRequest candidatoRequest
            , BindingResult error
            , BindingResult result) throws Exception {
        if(result.hasErrors()){
            log.error(formatMessage(result));
            throw new Exception(formatMessage(result));
        }
        ResponseEntity<CandidatoRequest> candidatoRequestResponseEntity = null;
        try {
            candidatoRequestResponseEntity = candidatoService.validarCandidato(candidatoRequest);
        }catch (Exception e){
            log.error("E:"+e);
            throw new Exception("E:"+e);
        }
        return candidatoRequestResponseEntity;
    }

    /**
     * Retorno de Estadisticas: count_mutant_dna,count_human_dna,ratio
     * @return Estadisticas calculadas
     */
    @GetMapping("/stats")
    @Operation(summary = "Estadisticas al momento")
    ResponseEntity<Estadisticas> estadisticas() throws Exception {
        ResponseEntity<Estadisticas> estadisticas = null;
        try{
            estadisticas = candidatoService.estadisticas();
        }catch (Exception e){
            log.error("E:"+e);
            throw new Exception(""+e);
        }
        return estadisticas;
    }

}
