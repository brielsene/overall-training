package br.com.overall.training.infra.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice
public class TratamentoDeErros {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity trataErroConstraint(){
        return  ResponseEntity.badRequest().body("este user já existe");
    }



}
