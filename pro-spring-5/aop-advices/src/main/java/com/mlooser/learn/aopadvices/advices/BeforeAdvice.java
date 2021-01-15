package com.mlooser.learn.aopadvices.advices;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeforeAdvice implements MethodBeforeAdvice{

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		log.info("BeforeAdvice.before");
	}

}
