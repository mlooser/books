package com.mlooser.learn.aoppointcuts.beans;

import com.mlooser.learn.aoppointcuts.AdviceRequired;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TestBean {
	public void testMethod(String param) {
		log.info(param);
	}
	
	@AdviceRequired
	public void annotadedTestMethod(String param) {
		log.info(param);
	}
}
