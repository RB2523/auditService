package com.auditService.filter;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auditService.DTO.RateLimitProperties;
import com.auditService.service.RateLimitService;

import io.github.bucket4j.Bucket;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tools.jackson.databind.ObjectMapper;

@Component
public class RateLimitFilter extends OncePerRequestFilter {

	@Autowired
	private RateLimitService rateLimitService;
	
	@Autowired
	private RateLimitProperties properties;

	@Autowired
	private ObjectMapper mapper  ;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String clientIp = request.getRemoteAddr();

		Bucket bucket = rateLimitService.resolveBucket(clientIp);

		if (!bucket.tryConsume(1)) {

			response.setStatus(properties.getStatusCode());
			response.setContentType("application/json");

			mapper.writeValue(response.getWriter(), Map.of("status", properties.getStatusCode(), "message", properties.getMessage()));

			return;
		}

		filterChain.doFilter(request, response);

	}

}
