package com.mlooser.learn.aopaspectj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mlooser.learn.aopaspectj.components.SampleComponent;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class AopAspectjApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(AopAspectjApplication.class, args);
		
		SampleComponent c1 = ctx.getBean("component1",SampleComponent.class);
		SampleComponent c2 = ctx.getBean("component2",SampleComponent.class);
		log.info("==================");
		c1.printMsg("This should be adviced");
		log.info("==================");
		c1.printMsg("This should be adviced with after");
		log.info("==================");
		c2.printMsg("This should NOT be adviced");
		log.info("==================");
	}
	

}

