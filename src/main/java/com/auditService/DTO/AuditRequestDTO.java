package com.auditService.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

public class AuditRequestDTO {

	 @Schema(
		        description = "Website URL to audit",
		        example = "https://google.com"
		    )
	
	private String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
