package com.auditService.service;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auditService.DTO.RateLimitProperties;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;

@Service
public class RateLimitService {

	@Autowired
	private RateLimitProperties properties;

	private final Map<String, Bucket> buckets = new ConcurrentHashMap<>();

	public Bucket resolveBucket(String clientId) {
		return buckets.computeIfAbsent(clientId, id -> createBucket());
	}

	private Bucket createBucket() {

		Refill refill = "GREEDY".equalsIgnoreCase(properties.getRefillStrategy())
				? Refill.greedy(properties.getRefillTokens(), properties.getRefillDuration())
				: Refill.intervally(properties.getRefillTokens(), properties.getRefillDuration());

		Bandwidth bandwidth = Bandwidth.classic(properties.getCapacity(), refill);

		return Bucket.builder().addLimit(bandwidth).build();
	}
}