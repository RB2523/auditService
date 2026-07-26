package com.auditService.DTO;

import java.time.Duration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rate-limit")
public class RateLimitProperties {

    private boolean enabled;
    private long capacity;
    private long refillTokens;
    private Duration refillDuration;
    private String refillStrategy;
    private int statusCode;
    private String message;
    private String clientIdType;
    
    
    
    
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public long getCapacity() {
		return capacity;
	}
	public void setCapacity(long capacity) {
		this.capacity = capacity;
	}
	public long getRefillTokens() {
		return refillTokens;
	}
	public void setRefillTokens(long refillTokens) {
		this.refillTokens = refillTokens;
	}
	public Duration getRefillDuration() {
		return refillDuration;
	}
	public void setRefillDuration(Duration refillDuration) {
		this.refillDuration = refillDuration;
	}
	public String getRefillStrategy() {
		return refillStrategy;
	}
	public void setRefillStrategy(String refillStrategy) {
		this.refillStrategy = refillStrategy;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getClientIdType() {
		return clientIdType;
	}
	public void setClientIdType(String clientIdType) {
		this.clientIdType = clientIdType;
	}

    
}