package com.mlooser.learn.aoppointcuts.pointcuts;

import java.lang.reflect.Method;

import org.springframework.aop.support.DynamicMethodMatcherPointcut;

public class SimpleDynamicPointcut extends DynamicMethodMatcherPointcut {

	private Object argValue;
	
	public SimpleDynamicPointcut(Object argValue) {
		super();
		this.argValue = argValue;
	}

	@Override
	public boolean matches(Method method, Class<?> targetClass, Object... args) {
		if(args.length<1)
			return false;
		
		return args[0].equals(argValue);
	}

}
