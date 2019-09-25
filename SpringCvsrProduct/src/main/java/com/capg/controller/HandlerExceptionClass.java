package com.capg.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.capg.model.ErrorDetails;
import com.capg.userException.UserNotFoundException;



@ControllerAdvice
@RestController
public class HandlerExceptionClass extends ResponseEntityExceptionHandler {
	
		@ExceptionHandler(value = UserNotFoundException.class)
		 public final ResponseEntity<ErrorDetails> handleNotFoundException(UserNotFoundException ex, WebRequest request) {
			ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
			        request.getDescription(false));
			    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
		   }
		
	}


