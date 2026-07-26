package com.auditService.exception;

import java.net.http.HttpTimeoutException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.auditService.DTO.AuditErrorResponse;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	
	private final String INTERNAL_SERVER_ERROR_MESSAGE = "An unexpected error occurred on the server. Please try again later." ;
	private final String INVALID_URL_MESSAGE = "Invalid URL" ;
	private final String TIMEOUT_ERROR_MESSAGE = "Request timed out" ;
	
	
	// all validation error handled here 
	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<AuditErrorResponse> validationExceptionHandler(ValidationException e) {
		System.out.println(e.toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuditErrorResponse(e.getMessage()));
	}
	
	// all 400 error handled here
	@ExceptionHandler({HttpClientErrorException.class ,IllegalArgumentException.class , HttpMessageNotReadableException.class})
	public ResponseEntity<AuditErrorResponse> urlNotAccessExceptionHandler(Exception e) {
		System.out.println(e.toString());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuditErrorResponse(INVALID_URL_MESSAGE));
	}
	
	// timeout
	@ExceptionHandler(HttpTimeoutException.class)
	public ResponseEntity<AuditErrorResponse> timeoutExceptionHandler(HttpTimeoutException e) {
		System.out.println(e.toString());
		return ResponseEntity.status(HttpStatus.REQUEST_TIMEOUT).body(new AuditErrorResponse(TIMEOUT_ERROR_MESSAGE));
	}
	
	
	// all 500 + whatever error left handled here
	@ExceptionHandler(Exception.class)
	public ResponseEntity<AuditErrorResponse> globalExceptionHandler(Exception e) {
		System.out.println(e.toString());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new AuditErrorResponse(INTERNAL_SERVER_ERROR_MESSAGE));
	}
}
