package com.auditService.filter;

import java.io.IOException;
import java.util.UUID;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestIdFilter extends OncePerRequestFilter {

	public static final String REQUEST_ID = "requestId";
	public static final String CLIENT_IP = "clientIp";

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String requestId = UUID.randomUUID().toString();
		String clientIp = getClientIp(request);

		MDC.put(REQUEST_ID, requestId);
		MDC.put(CLIENT_IP, clientIp);

		response.setHeader("X-Request-Id", requestId);

		try {
			filterChain.doFilter(request, response);
		} finally {
			MDC.clear();
		}
	}

	private String getClientIp(HttpServletRequest request) {

		String forwardedFor = request.getHeader("X-Forwarded-For");

		if (forwardedFor != null && !forwardedFor.isBlank()) {
			return forwardedFor.split(",")[0].trim();
		}

		return request.getRemoteAddr();
	}
}
