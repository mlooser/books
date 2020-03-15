package org.mlooser.learn.spring.configurebean;

import org.mlooser.learn.spring.configurebean.operations.Operation;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collection;

@SpringBootApplication
public class ConfigureBeanApplication {

    public static void main(String[] args) {

    	SpringApplication.run(ConfigureBeanApplication.class, args);
    }

    @Bean
    public Calculator calculator(Collection<Operation> operations){
    	return new Calculator(operations);
	}

	@Bean
	public ApplicationRunner applicationRunner(Calculator calculator){
    	return args ->{
			System.out.println("3 + 2 = " + calculator.calculate(3,2, '+'));
			System.out.println("3 * 2 = " + calculator.calculate(3,2, '*'));
		};
	}
}
