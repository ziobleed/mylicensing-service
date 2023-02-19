package com.myoptimalgrowth.licensingservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.RepresentationModel;

@Entity
@Table(name="licenses")
public class License extends RepresentationModel<License>{
	@Id
	@Column(name = "license_id", nullable = false)
	private int id;
	private String licenseId;
	private String description;
	@Column(name = "organization_id", nullable = false)
	private String organizationId;
	@Column(name = "product_name", nullable = false)
	private String productName;
	@Column(name = "license_type", nullable = false)
	private String licenseType;
	@Column(name = "comment")
	private String comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getProductName() {
		return productName;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getLicenseType() {
		return licenseType;
	}

	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	public License withComment(String comment) {
		this.comment = comment;
		return this;
	}

	@Override
	public String toString() {
		return "License [id=" + id + ", licenseId=" + licenseId + ", description=" + description + ", organizationId="
				+ organizationId + ", productName=" + productName + ", licenseType=" + licenseType + "]";
	}

}
