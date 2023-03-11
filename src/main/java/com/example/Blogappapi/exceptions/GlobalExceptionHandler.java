package com.example.Blogappapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<String> handleException(ResourseNotFoundException resourseNotFoundException) {
        return new ResponseEntity(resourseNotFoundException.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> Validator(MethodArgumentNotValidException exception) {
        //exception.getAllErrors().stream().collect(Collectors.groupingBy(objectError -> objectError.getField()))
      return   new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
