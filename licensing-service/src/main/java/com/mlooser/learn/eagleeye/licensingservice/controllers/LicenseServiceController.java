package com.mlooser.learn.eagleeye.licensingservice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mlooser.learn.eagleeye.licensingservice.config.ServiceConfig;
import com.mlooser.learn.eagleeye.licensingservice.model.License;
import com.mlooser.learn.eagleeye.licensingservice.services.LicenseServices;

@RestController
@RequestMapping("/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

	private LicenseServices licenseService;
	private ServiceConfig config;	
	
	public LicenseServiceController(LicenseServices licenseService, ServiceConfig config) {
		super();
		this.licenseService = licenseService;
		this.config = config;
	}

	@RequestMapping(value="/{lindenseId}", method = RequestMethod.GET)
	public License getLicenses(
			@PathVariable("organizationId") String organizationId, 
			@PathVariable("lindenseId") String licenseId) {
		
		Long organizationIdLong = Long.valueOf(organizationId);
		Long licenseIdLong = Long.valueOf(licenseId);
		
		License license = licenseService.getLicense(organizationIdLong, licenseIdLong);
		if(license == null) {
			license = new License(licenseIdLong, "Default License", organizationIdLong);
		}
		license.setComment(config.getExampleProperty());
		
		return license;		
	}
}
