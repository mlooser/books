package com.mlooser.learn.eagleeye.licensingservice.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mlooser.learn.eagleeye.licensingservice.model.License;

public interface LicenseRepository extends CrudRepository<License, Long>{
	List<License> findByOrganizationId(Long organizationId);
	License findByOrganizationIdAndId(Long organizationId,Long id);
}
