package com.mlooser.learn.eagleeye.licensingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LicensingServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(LicensingServiceApplication.class, args);
	}

}

