package com.patito.xmen.util;

import org.springframework.validation.BindingResult;

import java.util.stream.Collectors;

public interface ManejoValidaciones {
    default String formatMessage(BindingResult result){
        return result.getFieldErrors().stream()
                .map(err -> err.getDefaultMessage())
                .collect(Collectors.joining(","));
    }
}
