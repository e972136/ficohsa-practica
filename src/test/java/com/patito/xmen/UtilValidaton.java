package com.patito.xmen;

import com.patito.xmen.dao.CandidatoRequest;
import org.junit.jupiter.api.Test;
import org.junit.Before;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.ConstraintViolation;

import javax.validation.Validation;
import java.util.Set;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


//https://stackoverflow.com/questions/29069956/how-to-test-validation-annotations-of-a-class-using-junit
public class UtilValidaton {


    @Test
    public void utilCandidatoRequestTest01(){
        Validator validator;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        String[]base = {
            "XTGCXA",
                    "CAGTGC",
                    "TTGT",
                    "AGAAXG",
                    "TCACTG"};

        CandidatoRequest candidatoRequest = CandidatoRequest.of(base);
        Set<ConstraintViolation<CandidatoRequest>> validate = null;
        validate=validator.validate(candidatoRequest);
        assertFalse(validate.isEmpty());
    }

    @Test
    public void utilCandidatoRequestTest02(){
        Validator validator;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        String[]base = {
            "XTGCXA",
                    "CAGTGC",
                    "TTGT",
                    "AGAAXG",
                    "TCACTG"};

        CandidatoRequest candidatoRequest = CandidatoRequest.of(null);
        Set<ConstraintViolation<CandidatoRequest>> validate = null;
        validate=validator.validate(candidatoRequest);
        assertFalse(validate.isEmpty());
    }

    @Test
    public void utilCandidatoRequestTest03(){
        Validator validator;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        String[]base = {
                "XTGCXA",
                "TCACTG"};

        CandidatoRequest candidatoRequest = CandidatoRequest.of(base);
        Set<ConstraintViolation<CandidatoRequest>> validate = null;
        validate=validator.validate(candidatoRequest);
        assertFalse(validate.isEmpty());
    }

    @Test
    public void utilCandidatoRequestTest04(){
        Validator validator;
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
        String[]base = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};

        CandidatoRequest candidatoRequest = CandidatoRequest.of(base);
        Set<ConstraintViolation<CandidatoRequest>> validate = null;
        validate=validator.validate(candidatoRequest);
        assertTrue(validate.isEmpty());
    }
}

