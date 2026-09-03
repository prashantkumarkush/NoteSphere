package com.notesProject.exceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.notesProject.DTO.ExceptionDTO;
import com.notesProject.DTO.ValidationExceptionDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionDTO> HandleResourceNotFoundExpeption
	(ResourceNotFoundException ex, HttpServletRequest request){
		
		 ExceptionDTO exceptionResponse = new ExceptionDTO(
				LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value(),
				HttpStatus.NOT_FOUND.getReasonPhrase(),
				ex.getMessage(),
				request.getRequestURI()			
				);
		
		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(exceptionResponse);
		
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionDTO> HandleRuntimeExpeption(RuntimeException ex, HttpServletRequest request){
		
		ExceptionDTO exceptionResponse = new ExceptionDTO(
				LocalDateTime.now(),
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
				ex.getMessage(),
				request.getRequestURI()
				);
		
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(exceptionResponse);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationExceptionDTO> handleException(
	        MethodArgumentNotValidException ex,
	        HttpServletRequest request) {

	    Map<String, String> fieldErrors = new HashMap<>();

	    ex.getBindingResult()
	            .getFieldErrors()
	            .forEach(error ->
	                    fieldErrors.put(
	                            error.getField(),
	                            error.getDefaultMessage()
	                    )
	            );

	    ValidationExceptionDTO exceptionResponse = new ValidationExceptionDTO(
	                    LocalDateTime.now(),
	                    HttpStatus.BAD_REQUEST.value(),
	                    HttpStatus.BAD_REQUEST.getReasonPhrase(),
	                    request.getRequestURI(),
	                    fieldErrors
	            );

	    return ResponseEntity
	            .status(HttpStatus.BAD_REQUEST)
	            .body(exceptionResponse);
	}
	
	
}
