package com.mlooser.learn.eagleeye.organizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mlooser.learn.eagleeye.organizationservice.repositories.OrganizationRepository;

@SpringBootApplication
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OrganizationServiceApplication.class, args);
		OrganizationRepository oRepo = ctx.getBean(OrganizationRepository.class);
		oRepo.findAll().forEach(System.out::println);
	}

}

