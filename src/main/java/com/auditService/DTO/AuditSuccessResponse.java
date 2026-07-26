package com.auditService.DTO;

public class AuditSuccessResponse {

	private String url ;
	
	private HttpAuditResult httpAuditResult ;
	private SslAuditResult sslAuditResult ;
	private SeoAuditResult seoAuditResult ;
	private SecurityAuditResult securityAuditResult ;
	
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public HttpAuditResult getHttpAuditResult() {
		return httpAuditResult;
	}
	public void setHttpAuditResult(HttpAuditResult httpAuditResult) {
		this.httpAuditResult = httpAuditResult;
	}
	public SslAuditResult getSslAuditResult() {
		return sslAuditResult;
	}
	public void setSslAuditResult(SslAuditResult sslAuditResult) {
		this.sslAuditResult = sslAuditResult;
	}
	public SeoAuditResult getSeoAuditResult() {
		return seoAuditResult;
	}
	public void setSeoAuditResult(SeoAuditResult seoAuditResult) {
		this.seoAuditResult = seoAuditResult;
	}
	public SecurityAuditResult getSecurityAuditResult() {
		return securityAuditResult;
	}
	public void setSecurityAuditResult(SecurityAuditResult securityAuditResult) {
		this.securityAuditResult = securityAuditResult;
	}
	
	
	
	

	
	
	
	
}
