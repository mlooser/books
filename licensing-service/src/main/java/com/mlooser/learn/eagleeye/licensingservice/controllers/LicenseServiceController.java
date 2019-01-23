package com.mlooser.learn.eagleeye.licensingservice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mlooser.learn.eagleeye.licensingservice.model.License;

@RestController
@RequestMapping("/v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

	@RequestMapping(value="/{lindenseId}", method = RequestMethod.GET)
	public License getLicenses(
			@PathVariable("organizationId") String organizationId, 
			@PathVariable("lindenseId") String licenseId) {
		
		
		
		return new License(Long.valueOf(licenseId), "TestLicense", Long.valueOf(organizationId));		
	}
}
