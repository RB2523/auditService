package com.auditService.DTO;

public class AuditErrorResponse {

	private String errorMessage ;
	
	public AuditErrorResponse() {}

		
	public AuditErrorResponse(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}


	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}


	@Override
	public String toString() {
		return "errorMessage=" + errorMessage;
	}
	
	
	
	
}
