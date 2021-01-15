package com.mlooser.learn.aopaspectj.components;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SampleComponent {
	public void printMsg(String message) {
		log.info(message);
	}
}
