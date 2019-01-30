package com.mlooser.learn.aopintroduction;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public SimplePojo simplePojo() {
		return new SimplePojo();
	}
	
	@Bean
	public Advisor modifyAwareAdvicer() {
		return new ModifyAwareAdvisor(); 
	}
	
	@Bean
	public ProxyFactoryBean modifyAwarePojo() {
		ProxyFactoryBean pfb = new ProxyFactoryBean();
		pfb.setTarget(simplePojo());
		pfb.setProxyTargetClass(true);
		pfb.addAdvisor(modifyAwareAdvicer());
		return pfb;
	}
}
