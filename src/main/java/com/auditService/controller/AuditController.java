package com.auditService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auditService.DTO.AuditErrorResponse;
import com.auditService.DTO.AuditRequestDTO;
import com.auditService.DTO.AuditSuccessResponse;
import com.auditService.service.AuditService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AuditController {

	@Autowired
	private AuditService auditService ;
	
	@Operation(summary = "Audit website")
	
	@ApiResponses({
	    @ApiResponse(
	        responseCode = "200",
	        description = "Audit completed successfully",
	        content = @Content(
	            mediaType = "application/json",
	            schema = @Schema(implementation = AuditSuccessResponse.class)
	        )
	    ),
	    @ApiResponse(
	        responseCode = "400",
	        description = "Invalid URL",
	        content = @Content(
	            mediaType = "application/json",
	            schema = @Schema(implementation = AuditErrorResponse.class)
	        )
	    ),
	    @ApiResponse(
		        responseCode = "408",
		        description = "Request Timeout",
		        content = @Content(
		            mediaType = "application/json",
		            schema = @Schema(implementation = AuditErrorResponse.class)
		        )
		    ),
	    @ApiResponse(
	        responseCode = "429",
	        description = "Rate limit exceeded / Server Busy ",
	        content = @Content(
	            mediaType = "application/json",
	            schema = @Schema(implementation = AuditErrorResponse.class)
	        )
	    ),
	    @ApiResponse(
	        responseCode = "500",
	        description = "Internal Server Error",
	        content = @Content(
	            mediaType = "application/json",
	            schema = @Schema(implementation = AuditErrorResponse.class)
	        )
	    )
	})
	
	@PostMapping("/audit")
	public ResponseEntity<AuditSuccessResponse>  auditUrl(@RequestBody AuditRequestDTO auditRequestDTO ) throws Exception {
		return auditService.auditUrl(auditRequestDTO);
	}
	
	
//	@GetMapping("/timeout")
//	public String  timeoutTesting( ) throws Exception {
//		Thread.sleep(10000);
//		//throw new Exception("ASDas");
//		return "timeout testing";
//	}
}
