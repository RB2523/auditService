package com.auditService.DTO;

public class HeaderCheck {

	 private boolean present;
	 private String value ;
	 
	 
	 
	 
	public HeaderCheck(boolean present, String value) {
		super();
		this.present = present;
		this.value = value;
	}
	
	
	public boolean isPresent() {
		return present;
	}
	public void setPresent(boolean present) {
		this.present = present;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	 
	 
}
