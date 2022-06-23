package com.patito.xmen.Controller;

import com.patito.xmen.entity.Candidato;
import com.patito.xmen.repository.CandidatoRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Este controller esta pensado para mantenimiento/prueba de la bd.
 * este debe ser bloqueado en momento de produccion.
 * @since  2022/06/22
 * @author GasparCalix
 * */

@RestController
public class BDController {
    private final CandidatoRepository repository;


    public BDController(CandidatoRepository repository) {
        this.repository = repository;
    }

    @DeleteMapping("/limpiar")
    @Operation(summary = "limpiar BD")
    public ResponseEntity<String> limpiar() throws Exception {
        try{
        repository.deleteAll();
        }catch (Exception e){
            throw new Exception(""+e);
        }
        return ResponseEntity.ok("droped");
    }

    @GetMapping("/listar")
    @Operation(summary = "listar BD")
    public ResponseEntity<List<Candidato>> listar() throws Exception {
        List<Candidato> all=null;
        try{
            all = repository.findAll();
        }catch (Exception e){
            throw new Exception(""+e);
        }
        return ResponseEntity.ok(all);
    }
}
