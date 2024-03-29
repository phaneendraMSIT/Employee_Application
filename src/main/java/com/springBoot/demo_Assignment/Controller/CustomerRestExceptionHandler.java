package com.springBoot.demo_Assignment.Controller;

import com.springBoot.demo_Assignment.Entity.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(EmployeeNotFoundException emple){

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(),emple.getMessage(),System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handlerException(Exception exp){

        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),exp.getMessage(),System.currentTimeMillis());

        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
