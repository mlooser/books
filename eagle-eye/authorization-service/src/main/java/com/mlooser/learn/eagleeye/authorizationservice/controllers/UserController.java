package com.mlooser.learn.eagleeye.authorizationservice.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@RequestMapping(value="/user", produces="application/json")
	public Map<String,Object> getUsers(OAuth2Authentication user){
		Map<String,Object> usersInfo = new HashMap<>();
		
		usersInfo.put("user",
				user.getUserAuthentication().getPrincipal()
		);
		
		usersInfo.put("authorities",
				user.getUserAuthentication().getAuthorities()
		);
		
		return usersInfo;
	}
}
