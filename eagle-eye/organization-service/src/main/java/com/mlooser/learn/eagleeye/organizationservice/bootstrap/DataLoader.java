package com.mlooser.learn.eagleeye.organizationservice.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.mlooser.learn.eagleeye.organizationservice.model.Organization;
import com.mlooser.learn.eagleeye.organizationservice.repositories.OrganizationRepository;

@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent>{

	private OrganizationRepository organizationRepository;	
	
	public DataLoader(OrganizationRepository organizationRepository) {
		super();
		this.organizationRepository = organizationRepository;
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		organizationRepository.save(new Organization(1l, "Organization_1", "1111", "Address_1"));
		organizationRepository.save(new Organization(2l, "Organization_2", "2222", "Address_2"));
		organizationRepository.save(new Organization(3l, "Organization_3", "3333", "Address_3"));
	}

}
