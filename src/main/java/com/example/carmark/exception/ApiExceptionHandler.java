package com.example.carmark.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice // this means this class used for exception handling
public class ApiExceptionHandler{

    @ExceptionHandler(value = {ApiRequestException.class})
   public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {

       ApiException exception = new ApiException(
               e.getMessage(),
               e.getCause(),
               HttpStatus.BAD_REQUEST.value(),
               ZonedDateTime.now());
       return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);

   }

}
