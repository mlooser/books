package org.mlooser.learn.spring.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from Spring Boot 2";
    }
}
