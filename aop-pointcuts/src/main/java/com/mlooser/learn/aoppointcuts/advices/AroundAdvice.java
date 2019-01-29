package com.mlooser.learn.aoppointcuts.advices;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AroundAdvice implements MethodInterceptor{

	private String message;
	
	public AroundAdvice(String message) {
		super();
		this.message = message;
	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		log.info(message);
		return invocation.proceed();
	}

}
