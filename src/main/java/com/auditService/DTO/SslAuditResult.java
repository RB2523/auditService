package com.auditService.DTO;

import java.time.LocalDate;

public class SslAuditResult {

	private boolean https;
	private boolean valid;
	private String issuer;
	private String subject;
	private LocalDate expiryDate;
	private long daysRemaining;
	
	
	public SslAuditResult(boolean https, boolean valid, String issuer, String subject, LocalDate expiryDate, long daysRemaining) {
		this.https = https ;
		this.valid = valid ;
		this.issuer = issuer ;
		this.subject = subject ;
		this.expiryDate = expiryDate ;
		this.daysRemaining = daysRemaining ;
	}
	
	
	public boolean isHttps() {
		return https;
	}
	public void setHttps(boolean https) {
		this.https = https;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	public long getDaysRemaining() {
		return daysRemaining;
	}
	public void setDaysRemaining(long daysRemaining) {
		this.daysRemaining = daysRemaining;
	}
	
	
}
