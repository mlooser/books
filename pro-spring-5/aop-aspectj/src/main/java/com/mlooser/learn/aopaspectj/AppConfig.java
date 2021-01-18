package com.mlooser.learn.aopaspectj;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mlooser.learn.aopaspectj.components.AdviceComponent;
import com.mlooser.learn.aopaspectj.components.SampleComponent;

@Configuration
public class AppConfig {
	
	@Bean
	public SampleComponent component1() {
		return new SampleComponent();
	}
	
	@Bean
	public SampleComponent component2() {
		return new SampleComponent();
	}
	
	@Bean
	public AdviceComponent adviceComponent() {
		return new AdviceComponent();
	}
}
