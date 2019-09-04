package com.revature.caliber.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.revature.caliber.exception.ErrorMessage;
import com.revature.caliber.exception.ValidatorException;

@ControllerAdvice
public class RESTExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final Logger log = LoggerFactory.getLogger(RESTExceptionHandler.class);
	
	@ExceptionHandler(ValidatorException.class)
	public ResponseEntity<Object> handleException1(ValidatorException e) {
		log.debug("Validator Exception: { }", e.getMessage());
		ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
		return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
}
