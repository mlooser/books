package com.mlooser.learn.eagleeye.organizationservice.services;

import java.util.List;

import com.mlooser.learn.eagleeye.organizationservice.model.Organization;

public interface OrganizationService {
	Organization getOrganizationById(Long id);
	Organization save(Organization organization);
	void delete(Long id);
	List<Organization> getAll();
}
