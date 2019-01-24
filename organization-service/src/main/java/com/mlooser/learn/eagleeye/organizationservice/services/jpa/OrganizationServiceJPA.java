package com.mlooser.learn.eagleeye.organizationservice.services.jpa;

import com.mlooser.learn.eagleeye.organizationservice.model.Organization;
import com.mlooser.learn.eagleeye.organizationservice.repositories.OrganizationRepository;
import com.mlooser.learn.eagleeye.organizationservice.services.OrganizationService;

public class OrganizationServiceJPA implements OrganizationService{

	private OrganizationRepository organizationRepository;
	
	@Override
	public Organization getOrganizationById(Long id) {
		return organizationRepository.findById(id).orElse(null);
	}

	@Override
	public Organization save(Organization organization) {
		return organizationRepository.save(organization);
	}

}
