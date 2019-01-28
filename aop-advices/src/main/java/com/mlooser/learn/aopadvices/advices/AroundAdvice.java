package com.mlooser.learn.aopadvices.advices;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AroundAdvice implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		log.info("AroundAdvice.invoke.before");
		Object ret = invocation.proceed();
		log.info("AroundAdvice.invoke.after");
		return ret;
	}

}
