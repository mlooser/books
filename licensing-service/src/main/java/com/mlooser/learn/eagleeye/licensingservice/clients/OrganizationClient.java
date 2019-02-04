package com.mlooser.learn.eagleeye.licensingservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mlooser.learn.eagleeye.licensingservice.model.Organization;

@FeignClient("organizationservice")
public interface OrganizationClient {

	@RequestMapping(
			method=RequestMethod.GET,
			value="organizations/{organizationId}",
			consumes="application/json"
			)
	Organization getOrganization(@PathVariable("organizationId") Long organizationId);
}
