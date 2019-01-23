package com.mlooser.learn.eagleeye.licensingservice.model;

public class License {
	private Long id;
	private String productName;
	private Long organizationId;
	
	public License() {
		super();
	}
	
	public License(Long id, String productName, Long organizationId) {
		super();
		this.id = id;
		this.productName = productName;
		this.organizationId = organizationId;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}
	
}
