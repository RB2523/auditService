package com.auditService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.auditService.DTO.HttpAuditResult;

@Service
public class HttpAuditService {

	@Autowired
	private HttpClientService httpClientService ;
	
	public HttpAuditResult getHttpAuditResponse(String url) {
		
		long start = System.currentTimeMillis();
		
		HttpAuditResult httpAuditResult = new HttpAuditResult();
		ResponseEntity<String> urlResponse = httpClientService.fetch(url);
		
		long end = System.currentTimeMillis();
		
		httpAuditResult.setResponseTimeMs(end - start);
		httpAuditResult.setUrlStatusCode (urlResponse.getStatusCode().value());
		
		HttpStatus status = HttpStatus.valueOf(urlResponse.getStatusCode().value());
		httpAuditResult.setUrlStatusMessage(status.getReasonPhrase());
		
		HttpHeaders headers = urlResponse.getHeaders();
		
		httpAuditResult.setContentLength(headers.getContentLength());
		httpAuditResult.setContentType(headers.getFirst("Content-Type"));
		httpAuditResult.setServer(headers.getFirst("Server"));
		
		httpAuditResult.setBody(urlResponse.getBody());
		httpAuditResult.setHeaders(headers);
		
		
		
		return httpAuditResult;
	}
}
