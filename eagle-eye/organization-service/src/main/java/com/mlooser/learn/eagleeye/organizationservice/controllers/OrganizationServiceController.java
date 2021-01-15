package com.mlooser.learn.eagleeye.organizationservice.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mlooser.learn.eagleeye.organizationservice.model.Organization;
import com.mlooser.learn.eagleeye.organizationservice.services.OrganizationService;

@RestController
@RequestMapping(value = "organizations")
public class OrganizationServiceController {

	private OrganizationService organizationService;

	public OrganizationServiceController(OrganizationService organizationService) {
		super();
		this.organizationService = organizationService;
	}

	@RequestMapping(value = "/{organizationId}", method = RequestMethod.GET)
	public Organization getOrganization(@PathVariable("organizationId") Long organizationId) {
		return organizationService.getOrganizationById(organizationId);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Organization> getAllOrganizations() {
		return organizationService.getAll();
	}
	
	@RequestMapping(value = "/{organizationId}", method = RequestMethod.PUT)
	public void updateOrganization(@PathVariable("organizationId") Long organizationId, @RequestBody Organization organization) {
		organizationService.save(organization);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void saveOrganization(@RequestBody Organization organization) {
		organizationService.save(organization);
	}

	@RequestMapping(value = "/{organizationId}", method = RequestMethod.DELETE)
	@ResponseStatus(code=HttpStatus.NO_CONTENT)
	public void deleteOrganization(@PathVariable("organizationId") Long organizationId) {
		organizationService.delete(organizationId);
	}
}
