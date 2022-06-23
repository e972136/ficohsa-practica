package com.patito.xmen.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
/**
 * Clase manejo de validacion de la cadena dna
 * @since  2022/06/22
 * @author GasparCalix
 * */
public class DnaValidator implements ConstraintValidator<DnaValidation, String[]> {

    /**
     * Validacion de Mutantes
     * @param value, constraintValidatorContext
     * @return boolean
     */
    @Override
    public boolean isValid(String[] value, ConstraintValidatorContext constraintValidatorContext) {
        if(value==null){
            return false;
        }
        //que al menos tenga 4 filas
        if(value.length<4){
            return false;
        }

        //que todas las filas tengan la misma longitud y al menos 4
        int rectangular = value[0].length();
        for(String line:value){
            if(line.length()<4 || line.length()!=rectangular){
                return false;
            }
        }
        return true;
    }
}
