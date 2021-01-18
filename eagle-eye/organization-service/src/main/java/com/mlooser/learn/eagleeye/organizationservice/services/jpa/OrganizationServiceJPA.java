package com.mlooser.learn.eagleeye.organizationservice.services.jpa;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Service;

import com.mlooser.learn.eagleeye.organizationservice.model.Organization;
import com.mlooser.learn.eagleeye.organizationservice.repositories.OrganizationRepository;
import com.mlooser.learn.eagleeye.organizationservice.services.OrganizationService;

@Service
public class OrganizationServiceJPA implements OrganizationService{

	private OrganizationRepository organizationRepository;
	
	
	public OrganizationServiceJPA(OrganizationRepository organizationRepository) {
		super();
		this.organizationRepository = organizationRepository;
	}

	@Override
	public Organization getOrganizationById(Long id) {
		return organizationRepository.findById(id).orElse(null);
	}

	@Override
	public Organization save(Organization organization) {
		return organizationRepository.save(organization);
	}

	@Override
	public void delete(Long id) {
		organizationRepository.deleteById(id);		
	}
	
	@Override
	public List<Organization> getAll(){
		return StreamSupport
			.stream(organizationRepository.findAll().spliterator(), false)
			.collect(Collectors.toList());
	}
}
