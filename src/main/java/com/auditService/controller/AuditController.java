package com.auditService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auditService.DTO.AuditRequestDTO;
import com.auditService.DTO.AuditSuccessResponse;
import com.auditService.service.AuditService;

@RestController
public class AuditController {

	@Autowired
	private AuditService auditService ;
	
	@PostMapping("/audit")
	public ResponseEntity<AuditSuccessResponse>  auditUrl(@RequestBody AuditRequestDTO auditRequestDTO ) throws Exception {
		return auditService.auditUrl(auditRequestDTO);
	}
	
	
	@GetMapping("/timeout")
	public String  timeoutTesting( ) throws Exception {
		Thread.sleep(10000);
		//throw new Exception("ASDas");
		return "timeout testing";
	}
}
