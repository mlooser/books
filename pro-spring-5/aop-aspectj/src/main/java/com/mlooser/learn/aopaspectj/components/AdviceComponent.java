package com.mlooser.learn.aopaspectj.components;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
public class AdviceComponent {

	@Pointcut("bean(component1)")
	public void isComponent1() {	
	}
	
	@Pointcut("execution(* *..printMsg(String))")
	public void hasStringArg() {
		
	}
	
	@Before("isComponent1()")
	public void beforeAdvice(JoinPoint jp) {
		log.info("beforeAdvice");
	}
	
	@After("isComponent1() && hasStringArg() && args(val)")
	public void afterAdvice(JoinPoint jp,String val) {
		if(val.contains("after")) {
			log.info("afterAdvice");
		}
	}
	
	@Around("isComponent1()")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		log.info("aroundAdvice.before");
		Object ret = pjp.proceed();
		log.info("aroundAdvice.after");
		return ret;
	}
}
