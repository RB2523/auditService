package com.auditService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.auditService.DTO.AuditRequestDTO;
import com.auditService.DTO.AuditSuccessResponse;
import com.auditService.DTO.HttpAuditResult;
import com.auditService.exception.ValidationException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class AuditService {
	
	@Autowired
	private HttpAuditService httpAuditService ;
	
	@Autowired 
	private SslAuditService sslAuditService ;
	
	@Autowired
	private SeoAuditService seoAuditService ;
	
	@Autowired
	private SecurityAuditService securityAuditService ;

	
	@Cacheable(value = "audit", key = "#auditRequestDTO.getUrl()")
	public ResponseEntity<AuditSuccessResponse> auditUrl( AuditRequestDTO auditRequestDTO ) throws Exception {
		
		Thread.sleep(10000);
		log.info("Start auditing ");
		
		AuditSuccessResponse auditResponseDTO = new AuditSuccessResponse();
		
		// validating url
		if(auditRequestDTO.getUrl() == null ||  auditRequestDTO.getUrl().trim().length() == 0 ) {
			throw new ValidationException("Url cannot be empty");
		}
		
		log.info("httpAuditResponse for {}", auditRequestDTO.getUrl());
		HttpAuditResult httpAuditResponse = httpAuditService.getHttpAuditResponse(auditRequestDTO.getUrl());
		
		
		auditResponseDTO.setUrl(auditRequestDTO.getUrl());
		auditResponseDTO.setHttpAuditResult(httpAuditResponse);
		
		log.info("fetching SslAuditResponse for {}", auditRequestDTO.getUrl());
		auditResponseDTO.setSslAuditResult(sslAuditService.getSslAuditResponse(auditRequestDTO.getUrl()));
		
		if(httpAuditResponse.getBody() != null ) {
			log.info("fetching SeoAuditResponse for {}", auditRequestDTO.getUrl());
			auditResponseDTO.setSeoAuditResult(seoAuditService.getSeoAuditResponse(httpAuditResponse.getBody()));			
		}
		
		if(httpAuditResponse.getHeaders() != null ) {
			log.info("fetching SecurityAuditResponse for {}", auditRequestDTO.getUrl());
			auditResponseDTO.setSecurityAuditResult( securityAuditService.getSecurityAuditResponse(httpAuditResponse.getHeaders()));			
		}
		
		log.info("end auditing for {}", auditRequestDTO.getUrl());
		
		return ResponseEntity.status(HttpStatus.OK).body(auditResponseDTO) ;
	}
}
