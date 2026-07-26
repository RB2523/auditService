package com.auditService.service;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.auditService.DTO.HeaderCheck;
import com.auditService.DTO.SecurityAuditResult;

@Service
public class SecurityAuditService {

	public SecurityAuditResult getSecurityAuditResponse(HttpHeaders headers) {

		return new SecurityAuditResult(

				check(headers, "Strict-Transport-Security"),

				check(headers, "Content-Security-Policy"),

				check(headers, "X-Frame-Options"),

				check(headers, "X-Content-Type-Options"),

				check(headers, "Referrer-Policy"),

				check(headers, "Permissions-Policy"),

				check(headers, "Cross-Origin-Opener-Policy"),

				check(headers, "Cross-Origin-Embedder-Policy"),

				check(headers, "Cross-Origin-Resource-Policy")

		);

	}

	private HeaderCheck check(HttpHeaders headers, String headerName) {

		String value = headers.getFirst(headerName);

		return new HeaderCheck(value != null, value);
	}
}