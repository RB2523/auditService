package com.auditService.DTO;

public class SecurityAuditResult {

	 private HeaderCheck hsts;

	 private HeaderCheck csp;

	 private HeaderCheck xFrameOptions;

	 private HeaderCheck xContentTypeOptions;

	 private HeaderCheck referrerPolicy;

	 private HeaderCheck permissionsPolicy;

	 private HeaderCheck coop;

	 private HeaderCheck coep;

	 private HeaderCheck corp;
	 
	 
	 
	 

	public SecurityAuditResult(HeaderCheck hsts, HeaderCheck csp, HeaderCheck xFrameOptions,
			HeaderCheck xContentTypeOptions, HeaderCheck referrerPolicy, HeaderCheck permissionsPolicy,
			HeaderCheck coop, HeaderCheck coep, HeaderCheck corp) {
		super();
		this.hsts = hsts;
		this.csp = csp;
		this.xFrameOptions = xFrameOptions;
		this.xContentTypeOptions = xContentTypeOptions;
		this.referrerPolicy = referrerPolicy;
		this.permissionsPolicy = permissionsPolicy;
		this.coop = coop;
		this.coep = coep;
		this.corp = corp;
	}

	
	
	public HeaderCheck getHsts() {
		return hsts;
	}

	public void setHsts(HeaderCheck hsts) {
		this.hsts = hsts;
	}

	public HeaderCheck getCsp() {
		return csp;
	}

	public void setCsp(HeaderCheck csp) {
		this.csp = csp;
	}

	public HeaderCheck getxFrameOptions() {
		return xFrameOptions;
	}

	public void setxFrameOptions(HeaderCheck xFrameOptions) {
		this.xFrameOptions = xFrameOptions;
	}

	public HeaderCheck getxContentTypeOptions() {
		return xContentTypeOptions;
	}

	public void setxContentTypeOptions(HeaderCheck xContentTypeOptions) {
		this.xContentTypeOptions = xContentTypeOptions;
	}

	public HeaderCheck getReferrerPolicy() {
		return referrerPolicy;
	}

	public void setReferrerPolicy(HeaderCheck referrerPolicy) {
		this.referrerPolicy = referrerPolicy;
	}

	public HeaderCheck getPermissionsPolicy() {
		return permissionsPolicy;
	}

	public void setPermissionsPolicy(HeaderCheck permissionsPolicy) {
		this.permissionsPolicy = permissionsPolicy;
	}

	public HeaderCheck getCoop() {
		return coop;
	}

	public void setCoop(HeaderCheck coop) {
		this.coop = coop;
	}

	public HeaderCheck getCoep() {
		return coep;
	}

	public void setCoep(HeaderCheck coep) {
		this.coep = coep;
	}

	public HeaderCheck getCorp() {
		return corp;
	}

	public void setCorp(HeaderCheck corp) {
		this.corp = corp;
	}
	 
	 
}
