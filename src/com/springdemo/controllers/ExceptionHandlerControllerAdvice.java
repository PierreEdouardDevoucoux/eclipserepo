package com.springdemo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.demos.errors.ErrorResponse;
import com.springdemo.exception.StudentNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

		@ExceptionHandler
		public ResponseEntity<ErrorResponse>handleException(StudentNotFoundException exception)
		{
			ErrorResponse err = new ErrorResponse();
			err.setStatus(HttpStatus.NOT_FOUND.value());
			err.setMessage("student not found tappe un bon id");
			err.setTemps(System.currentTimeMillis());
			return new ResponseEntity<>(err,HttpStatus.NOT_FOUND);
		}
		
		@ExceptionHandler
		public ResponseEntity<ErrorResponse>handleException(NumberFormatException exception)
		{
			ErrorResponse err = new ErrorResponse();
			err.setStatus(HttpStatus.NOT_ACCEPTABLE.value());
			err.setMessage("tappe un id willy");
			err.setTemps(System.currentTimeMillis());
			return new ResponseEntity<>(err,HttpStatus.NOT_ACCEPTABLE);
		}
		
		@ExceptionHandler
		public ResponseEntity<ErrorResponse>handleException(Exception exception)
		{
			ErrorResponse err = new ErrorResponse();
			err.setStatus(HttpStatus.BAD_REQUEST.value());
			err.setMessage("erreur standard");
			err.setTemps(System.currentTimeMillis());
			return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		}
	
}
