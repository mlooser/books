package com.mlooser.learn.profiles;

import com.mlooser.learn.profiles.services.MenuPrinter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProfilesApplication {

	public static void main(String[] args) {
             ApplicationContext ctx = SpringApplication.run(ProfilesApplication.class, args);
             
             MenuPrinter menuPrinter = ctx.getBean("menuPrinter",MenuPrinter.class);
             
             System.out.println("Menu:" + menuPrinter.printMenu());
	}

}

