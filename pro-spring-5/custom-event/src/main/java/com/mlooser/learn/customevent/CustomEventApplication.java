package com.mlooser.learn.customevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CustomEventApplication {

	public static void main(String[] args) {
            ApplicationContext ctx = SpringApplication.run(CustomEventApplication.class, args);
            MyEventPublisher publisher = ctx.getBean(MyEventPublisher.class);
            publisher.publish("my event test");
            System.out.println("Test done");
	}

}

