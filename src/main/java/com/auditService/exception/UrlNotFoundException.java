package com.auditService.exception;

public class UrlNotFoundException extends Exception {

	private String message ;

	public UrlNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
