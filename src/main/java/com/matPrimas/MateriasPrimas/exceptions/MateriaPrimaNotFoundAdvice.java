package com.matPrimas.MateriasPrimas.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody

public class MateriaPrimaNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(MateriaPrimaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String EntityNotFoundAdvice(MateriaPrimaNotFoundException ex){
        return ex.getMessage();
    }
}
