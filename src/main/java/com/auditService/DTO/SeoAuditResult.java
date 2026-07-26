package com.auditService.DTO;

public class SeoAuditResult {
	
	private String title;
	private int titleLength;
	private String metaDescription;
	private int descriptionLength;
	private String canonical;
	private String robots;
	private int h1Count;
	private int images;
	private int imagesWithoutAlt;
	private String ogTitle;
	private String ogDescription;
	
	
	
	public SeoAuditResult(String title, int titleLength, String metaDescription, int descriptionLength,
			String canonical, String robots, int h1Count, int images, int imagesWithoutAlt, String ogTitle,
			String ogDescription) {
		super();
		this.title = title;
		this.titleLength = titleLength;
		this.metaDescription = metaDescription;
		this.descriptionLength = descriptionLength;
		this.canonical = canonical;
		this.robots = robots;
		this.h1Count = h1Count;
		this.images = images;
		this.imagesWithoutAlt = imagesWithoutAlt;
		this.ogTitle = ogTitle;
		this.ogDescription = ogDescription;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public int getTitleLength() {
		return titleLength;
	}



	public void setTitleLength(int titleLength) {
		this.titleLength = titleLength;
	}



	public String getMetaDescription() {
		return metaDescription;
	}



	public void setMetaDescription(String metaDescription) {
		this.metaDescription = metaDescription;
	}



	public int getDescriptionLength() {
		return descriptionLength;
	}



	public void setDescriptionLength(int descriptionLength) {
		this.descriptionLength = descriptionLength;
	}



	public String getCanonical() {
		return canonical;
	}



	public void setCanonical(String canonical) {
		this.canonical = canonical;
	}



	public String getRobots() {
		return robots;
	}



	public void setRobots(String robots) {
		this.robots = robots;
	}



	public int getH1Count() {
		return h1Count;
	}



	public void setH1Count(int h1Count) {
		this.h1Count = h1Count;
	}



	public int getImages() {
		return images;
	}



	public void setImages(int images) {
		this.images = images;
	}



	public int getImagesWithoutAlt() {
		return imagesWithoutAlt;
	}



	public void setImagesWithoutAlt(int imagesWithoutAlt) {
		this.imagesWithoutAlt = imagesWithoutAlt;
	}



	public String getOgTitle() {
		return ogTitle;
	}



	public void setOgTitle(String ogTitle) {
		this.ogTitle = ogTitle;
	}



	public String getOgDescription() {
		return ogDescription;
	}



	public void setOgDescription(String ogDescription) {
		this.ogDescription = ogDescription;
	}
	
	
	
	
}
