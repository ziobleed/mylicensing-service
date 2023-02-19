package com.myoptimalgrowth.licensingservice.service;

import java.util.Locale;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.myoptimalgrowth.licensingservice.config.ServiceConfig;
import com.myoptimalgrowth.licensingservice.model.License;
import com.myoptimalgrowth.licensingservice.repository.LicenseRepository;

@Service
public class LicenseService {

	@Autowired
	private MessageSource messages;

	@Autowired
	private LicenseRepository licenseRepository;

	@Autowired
	private ServiceConfig config;

	public License getLicense(String licenseId, String organizationId) {
		License license = licenseRepository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
		if (null == license) {
			throw new IllegalArgumentException(String.format(
					messages.getMessage("license.search.error.message", null, null), licenseId, organizationId));
		}
		return license.withComment(config.getProperty());
	}

	public License createLicense(License license) {
		license.setLicenseId(UUID.randomUUID().toString());
		licenseRepository.save(license);
		return license.withComment(config.getProperty());
	}

	public License updateLicense(License license, String organizationId) {
		licenseRepository.save(license);
		return license.withComment(config.getProperty());

	}

	public String deleteLicense(String licenseId, String organizationId) {
		String responseMessage = null;
		License license = new License();
		license.setLicenseId(licenseId);
		licenseRepository.delete(license);
		responseMessage = String.format(messages.getMessage(
		"license.delete.message", null, null),licenseId);
		return responseMessage;
	}
}
