package com.demo.Employees.GlobalExceptionHandler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.demo.Employees.Exception.ResourceNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	//@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException r,WebRequest request) {
		
		ErrorDetails error=new ErrorDetails(r.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<> (error,HttpStatus.NOT_FOUND);
		
	}

}
