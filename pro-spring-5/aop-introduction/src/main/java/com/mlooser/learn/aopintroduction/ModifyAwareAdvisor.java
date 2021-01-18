package com.mlooser.learn.aopintroduction;

import org.springframework.aop.support.DefaultIntroductionAdvisor;

public class ModifyAwareAdvisor extends DefaultIntroductionAdvisor{

	public ModifyAwareAdvisor() {
		super(new ModifyIntroduction());
	}

}
