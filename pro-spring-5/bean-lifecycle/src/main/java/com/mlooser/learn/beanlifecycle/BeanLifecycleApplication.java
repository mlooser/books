package com.mlooser.learn.beanlifecycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeanLifecycleApplication {

	public static void main(String[] args) {
            ApplicationContext ctx = SpringApplication.run(BeanLifecycleApplication.class, args);
            
            ctx.getBean("testLifecycleBean");
	}

}

