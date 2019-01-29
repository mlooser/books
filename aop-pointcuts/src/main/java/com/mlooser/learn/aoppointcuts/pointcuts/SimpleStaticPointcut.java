package com.mlooser.learn.aoppointcuts.pointcuts;

import java.lang.reflect.Method;

import org.springframework.aop.support.StaticMethodMatcherPointcutAdvisor;

public class SimpleStaticPointcut extends StaticMethodMatcherPointcutAdvisor{

	private String methodName;
	
	public SimpleStaticPointcut(String methodName) {
		super();
		this.methodName = methodName;
	}

	@Override
	public boolean matches(Method method, Class<?> targetClass) {
		return method.getName().equals(methodName);
	}

}
