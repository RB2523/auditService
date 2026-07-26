package com.auditService.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.benmanes.caffeine.cache.Caffeine;

@Configuration
public class CacheConfig {
	
	@Value("${cache.audit.ttl}")
	private int ttl;

	@Value("${cache.audit.max-size}")
	private long maxSize;

	@Bean
	public CacheManager cacheManager() {

		CaffeineCacheManager cacheManager = new CaffeineCacheManager("audit");

		cacheManager.setCaffeine(Caffeine.newBuilder().maximumSize(maxSize).expireAfterWrite(Duration.ofMinutes(ttl)));

		return cacheManager;
	}

}