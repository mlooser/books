package com.mlooser.learn.eagleeye.licensingservice.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mlooser.learn.eagleeye.licensingservice.clients.OrganizationClient;
import com.mlooser.learn.eagleeye.licensingservice.config.ServiceConfig;
import com.mlooser.learn.eagleeye.licensingservice.model.License;
import com.mlooser.learn.eagleeye.licensingservice.model.Organization;
import com.mlooser.learn.eagleeye.licensingservice.services.LicenseServices;

@RestController
@RequestMapping("/organizations/{organizationId}/licenses")
public class LicenseServiceController {

	private LicenseServices licenseService;
	private ServiceConfig config;	
	private OrganizationClient organizationClient;
	
	public LicenseServiceController(LicenseServices licenseService, ServiceConfig config, OrganizationClient organizationClient) {
		super();
		this.licenseService = licenseService;
		this.config = config;
		this.organizationClient = organizationClient;
	}

	@RequestMapping(value="/{lindenseId}", method = RequestMethod.GET)
	public License getLicenses(
			@RequestHeader("Authorization") String authorizationHeader,
			@PathVariable("organizationId") String organizationId, 
			@PathVariable("lindenseId") String licenseId) {
		
		Long organizationIdLong = Long.valueOf(organizationId);
		Long licenseIdLong = Long.valueOf(licenseId);
		
		License license = licenseService.getLicense(organizationIdLong, licenseIdLong);
		if(license == null) {
			license = new License(licenseIdLong, "Default License", organizationIdLong);
		}
		license.setComment(config.getExampleProperty());
		System.out.println("Fetched AuthorizationHeaded " + authorizationHeader);
		Organization organization = organizationClient.getOrganization(authorizationHeader, organizationIdLong);
		license.setOrganization(organization);		
		
		return license;		
	}	
}
