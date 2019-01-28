package com.mlooser.learn.aopadvices.advices;

import org.springframework.aop.ThrowsAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThrowAdvice implements ThrowsAdvice {
	public void afterThrowing(RuntimeException ex) throws RuntimeException{
		log.info("TrowAdvice.afterRT."+ex.getMessage());
	}
}
