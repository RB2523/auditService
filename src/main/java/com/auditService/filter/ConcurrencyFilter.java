package com.auditService.filter;

import java.io.IOException;
import java.util.concurrent.Semaphore;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auditService.DTO.AuditErrorResponse;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

@Component
public class ConcurrencyFilter extends OncePerRequestFilter {

	private final Semaphore semaphore = new Semaphore(10);
	private final ObjectMapper objectMapper = new ObjectMapper();

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		if (!semaphore.tryAcquire()) {

			response.setStatus(429);
			response.getWriter().write(objectMapper.writeValueAsString(new AuditErrorResponse("Server Busy")));

			return;
		}

		try {
			filterChain.doFilter(request, response);
		} finally {
			semaphore.release();
		}
	}
}
