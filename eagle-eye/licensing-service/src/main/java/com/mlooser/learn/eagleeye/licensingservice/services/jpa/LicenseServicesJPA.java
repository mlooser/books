package com.mlooser.learn.eagleeye.licensingservice.services.jpa;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mlooser.learn.eagleeye.licensingservice.model.License;
import com.mlooser.learn.eagleeye.licensingservice.repositories.LicenseRepository;
import com.mlooser.learn.eagleeye.licensingservice.services.LicenseServices;

@Service
public class LicenseServicesJPA implements LicenseServices{

	private LicenseRepository licenseRepository;		
	
	public LicenseServicesJPA(LicenseRepository licenseRepository) {
		super();
		this.licenseRepository = licenseRepository;
	}

	@Override
	public License getLicense(Long organizationId, Long licenseId) {
		return licenseRepository.findByOrganizationIdAndId(organizationId, licenseId);
	}

	@Override
	public List<License> getLicenseByOrganizationId(Long organizationId) {		
		return licenseRepository.findByOrganizationId(organizationId);
	}

	@Override
	public License save(License license) {
		return licenseRepository.save(license);		
	}

}
