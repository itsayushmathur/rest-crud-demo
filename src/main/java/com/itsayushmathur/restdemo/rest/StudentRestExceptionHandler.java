package com.itsayushmathur.restdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(String.valueOf(System.currentTimeMillis()));

        //return responseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //add an exception handler for all exceptions
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("The params do not match the expected input. Please Check the input and try again.");
        error.setTimeStamp(String.valueOf(System.currentTimeMillis()));

        //return responseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
