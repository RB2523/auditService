package com.auditService.DTO;

import org.springframework.http.HttpHeaders;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class HttpAuditResult {

	private int urlStatusCode;
    private String urlStatusMessage;
    private long responseTimeMs;
    private String contentType;
    private long contentLength;
    private String server;
    
    
    @JsonIgnore
    private HttpHeaders headers;
    
    @JsonIgnore
    private String body ;
    
	

	public int getUrlStatusCode() {
		return urlStatusCode;
	}

	public void setUrlStatusCode(int urlStatusCode) {
		this.urlStatusCode = urlStatusCode;
	}

	public String getUrlStatusMessage() {
		return urlStatusMessage;
	}

	public void setUrlStatusMessage(String urlStatusMessage) {
		this.urlStatusMessage = urlStatusMessage;
	}

	public long getResponseTimeMs() {
		return responseTimeMs;
	}

	public void setResponseTimeMs(long responseTimeMs) {
		this.responseTimeMs = responseTimeMs;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public long getContentLength() {
		return contentLength;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public HttpHeaders getHeaders() {
		return headers;
	}

	public void setHeaders(HttpHeaders headers) {
		this.headers = headers;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

  
    
    
}
