package com.mlooser.learn.eagleeye.licensingservice.services;

import java.util.List;

import com.mlooser.learn.eagleeye.licensingservice.model.License;

public interface LicenseServices {
	License getLicense(Long organizationId, Long licenseId);
	List<License> getLicenseByOrganizationId(Long organizationId);
	License save(License license);
}
