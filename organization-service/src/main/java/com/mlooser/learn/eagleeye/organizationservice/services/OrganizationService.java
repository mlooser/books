package com.mlooser.learn.eagleeye.organizationservice.services;

import com.mlooser.learn.eagleeye.organizationservice.model.Organization;

public interface OrganizationService {
	Organization getOrganizationById(Long id);
	Organization save(Organization organization);
}
