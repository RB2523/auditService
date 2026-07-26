package com.auditService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class HttpClientService {

	@Autowired
	private RestClient restClient;

	public ResponseEntity<String> fetch(String url) {

	        return restClient.get()
	                .uri(url)
	                .retrieve()
	                .toEntity(String.class);
	}
}
