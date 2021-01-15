package com.mlooser.learn.JSR330;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class Jsr330Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Jsr330Application.class, args);
        MessageProducer producer = ctx.getBean("messageProducer", MessageProducer.class);
        System.out.println("Message: " + producer.getMessage());
    }
        
    @Bean
    public String testMsg(){
        return "JSR-330 is working!";
    }

}

