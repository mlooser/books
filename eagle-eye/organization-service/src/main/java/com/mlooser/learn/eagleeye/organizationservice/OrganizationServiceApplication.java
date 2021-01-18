package com.mlooser.learn.eagleeye.organizationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import com.mlooser.learn.eagleeye.organizationservice.repositories.OrganizationRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableResourceServer
public class OrganizationServiceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(OrganizationServiceApplication.class, args);
		OrganizationRepository oRepo = ctx.getBean(OrganizationRepository.class);
		oRepo.findAll().forEach(System.out::println);
	}

}

