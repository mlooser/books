package com.mlooser.learn.aopintroduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class AopIntroductionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AopIntroductionApplication.class, args);
		SimplePojo pojo = ctx.getBean("modifyAwarePojo",SimplePojo.class);
		ModifyAware ma = (ModifyAware) pojo;
		
		pojo.setProperty("v1");
		ma.clearIsModyfied();
		System.out.println("Before modification " + ma.isModyfied());
		pojo.setProperty("v2");
		System.out.println("After modification " + ma.isModyfied());
	}

}

