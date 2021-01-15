package com.mlooser.learn.aopintroduction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

public class AopIntroductionApplicationTests {

	@Test
	public void testIntroduction() {
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(new ModifyAwareAdvisor());
		pf.setTarget(new SimplePojo());
		pf.setOptimize(true);
		
		SimplePojo pojo1 = (SimplePojo)pf.getProxy();
		
		pojo1.setProperty("p1v1");
		
		ModifyAware ma1 = (ModifyAware) pojo1;
		ma1.clearIsModyfied();
		
		assertTrue(!ma1.isModyfied());
		
		pojo1.setProperty("p1v2");
		
		assertTrue(ma1.isModyfied());
		assertEquals(pojo1.getProperty(), "p1v2");
	}

}

