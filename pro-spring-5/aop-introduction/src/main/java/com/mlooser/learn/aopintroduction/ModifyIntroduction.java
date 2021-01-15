package com.mlooser.learn.aopintroduction;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.support.DelegatingIntroductionInterceptor;

public class ModifyIntroduction extends DelegatingIntroductionInterceptor implements ModifyAware{

	private static final String SET_PREFIX = "set";
	private static final String GET_PREFIX = "get";
	
	private boolean isModified = false;
	private Map<Method, Method> getterCache = new HashMap<>();
	
	@Override
	public boolean isModyfied() {
		return isModified;
	}

	@Override
	public void clearIsModyfied() {
		isModified = false;
	}
	
	@Override
	public Object invoke(MethodInvocation mi) throws Throwable {
		if(!isModified) {
			if(mi.getMethod().getName().startsWith(SET_PREFIX) && mi.getArguments().length == 1) {
				Method getter = getGetter(mi.getMethod());
				if(getter!=null) {
					Object newValue = mi.getArguments()[0];
					Object prevValue = getter.invoke(mi.getThis());
					if(newValue == null && prevValue == null) {
						isModified = false;
					}
					else if((newValue == null && prevValue!=null) 
						||(newValue != null && prevValue == null)) {
						isModified = true;
					}
					else {
						isModified = !newValue.equals(prevValue);
					}
				}
			}
		}
		
		return super.invoke(mi);
	}

	private Method getGetter(Method setter) {
		Method getter = getterCache.get(setter);
		if(getter!=null) {
			return getter;
		}
		
		String getterName = setter.getName().replaceFirst(SET_PREFIX, GET_PREFIX);
		try {
			getter = setter.getDeclaringClass().getMethod(getterName, null);
			getterCache.put(setter, getter);
			return getter;
		}catch(NoSuchMethodException ex) {
			return null;
		}
	}
}
