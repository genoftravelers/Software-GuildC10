/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kd.guessthenum.controller;

import com.kd.guessthenum.service.InvalidNumException;
import com.kd.guessthenum.service.NotFoundException;
import java.sql.SQLIntegrityConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Karma Dolkar <krmdlkr@gmail.com>
 */
@ControllerAdvice
@RestController
public class GuessNumControllerExceptionHandler extends ResponseEntityExceptionHandler{
    
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public final ResponseEntity<Error> handleSqlException(SQLIntegrityConstraintViolationException ex,
            WebRequest request) {
        Error err = new Error();
        err.setMessage(ex.getMessage());
        
        return new ResponseEntity<>(err, HttpStatus.UNAUTHORIZED);
}
       @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Error> handleNotFoundException(NotFoundException ex,
            WebRequest request) {
        Error err = new Error();
        err.setMessage(ex.getMessage());

        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }
    
     @ExceptionHandler(InvalidNumException.class)
    public final ResponseEntity<Error> handleGameCompleteException(InvalidNumException ex,
            WebRequest request) {
        Error err = new Error();
        err.setMessage(ex.getMessage());

        return new ResponseEntity<>(err, HttpStatus.NOT_ACCEPTABLE);
    }
}
