package com.auditService.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;

import com.auditService.DTO.SecurityAuditResult;
import com.auditService.service.SecurityAuditService;

class SecurityAuditServiceTest {

	private final SecurityAuditService service = new SecurityAuditService();

	@Test
	void shouldDetectSecurityHeaders() {

		HttpHeaders headers = new HttpHeaders();
		headers.add("X-Frame-Options", "DENY");
		headers.add("Content-Security-Policy", "default-src 'self'");

		SecurityAuditResult result = service.getSecurityAuditResponse(headers);

		assertTrue(result.getxFrameOptions().isPresent());
		assertEquals("DENY", result.getxFrameOptions().getValue());

		assertTrue(result.getCsp().isPresent());
		assertFalse(result.getHsts().isPresent());
	}

	@Test
	void shouldDetectMissingHeaders() {

		HttpHeaders headers = new HttpHeaders();

		SecurityAuditResult result = service.getSecurityAuditResponse(headers);

		assertFalse(result.getCsp().isPresent());

		assertFalse(result.getHsts().isPresent());
	}
}