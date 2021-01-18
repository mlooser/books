package com.mlooser.learn.aopadvices.beans;


import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestBean {

	public void testMethod() {
		log.info("TestBean.testMethod");
	}
	
	public void throwTestMethod() {
		log.info("TestBean.throwTestMethod");
		throw new RuntimeException("RTFromTestBean");
	}
	
}
