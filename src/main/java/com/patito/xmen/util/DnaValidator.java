package com.patito.xmen.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DnaValidator implements ConstraintValidator<DnaValidation, String[]> {
    @Override
    public boolean isValid(String[] value, ConstraintValidatorContext constraintValidatorContext) {
        if(value==null){
            return false;
        }
        if(value.length<4){
            return false;
        }
        for(String line:value){
            if(line.length()<4){
                return false;
            }
        }
        return true;
    }
}
