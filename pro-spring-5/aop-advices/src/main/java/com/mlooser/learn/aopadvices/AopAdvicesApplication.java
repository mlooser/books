package com.mlooser.learn.aopadvices;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mlooser.learn.aopadvices.advices.*;
import com.mlooser.learn.aopadvices.beans.TestBean;

@SpringBootApplication
public class AopAdvicesApplication {

	public static void main(String[] args) {
		//SpringApplication.run(AopProxyFactoryApplication.class, args);
		
		ProxyFactory proxyFactory = new ProxyFactory();
		proxyFactory.addAdvice(new BeforeAdvice());
		proxyFactory.addAdvice(new AfterAdvice());
		proxyFactory.addAdvice(new AroundAdvice());
		proxyFactory.addAdvice(new ThrowAdvice());
		proxyFactory.setTarget(new TestBean());
		
		TestBean bean = (TestBean) proxyFactory.getProxy();
		bean.testMethod();
		bean.throwTestMethod();
	}

}

