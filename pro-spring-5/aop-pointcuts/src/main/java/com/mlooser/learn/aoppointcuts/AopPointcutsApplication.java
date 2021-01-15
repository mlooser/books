package com.mlooser.learn.aoppointcuts;

import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.JdkRegexpMethodPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mlooser.learn.aoppointcuts.advices.AroundAdvice;
import com.mlooser.learn.aoppointcuts.beans.TestBean;
import com.mlooser.learn.aoppointcuts.pointcuts.SimpleDynamicPointcut;
import com.mlooser.learn.aoppointcuts.pointcuts.SimpleStaticPointcut;

@SpringBootApplication
public class AopPointcutsApplication {

	public static void main(String[] args) {
		runSimpleStaticPointcut();
		runSimpleDynamicPointcut();
		runNameMatchingPointcut();
		runRegexMatchingPointcut();
		runAnnotationMatchingPointcut();
		runComposablePointcut();
		runFlowControllPointcut();
	}

	private static void runComposablePointcut() {
		ProxyFactory pf = new ProxyFactory();
		
		AnnotationMatchingPointcut rmp = AnnotationMatchingPointcut
				.forMethodAnnotation(AdviceRequired.class);
		
		SimpleDynamicPointcut sdp = new SimpleDynamicPointcut("ComposablePointcut adviced");
		
		ComposablePointcut cp = new ComposablePointcut()
				.intersection(rmp)
				.intersection((Pointcut)sdp);
		
		pf.addAdvisor(new DefaultPointcutAdvisor(cp,
				new AroundAdvice("ComposablePointcut advice")));

		pf.setTarget(new TestBean());

		TestBean testBean = (TestBean) pf.getProxy();
		testBean.annotadedTestMethod("ComposablePointcut adviced");
		testBean.annotadedTestMethod("ComposablePointcut not adviced");
	}
	
	private static void runAnnotationMatchingPointcut() {
		ProxyFactory pf = new ProxyFactory();
		AnnotationMatchingPointcut rmp = AnnotationMatchingPointcut
				.forMethodAnnotation(AdviceRequired.class);
		
		pf.addAdvisor(new DefaultPointcutAdvisor(rmp,
				new AroundAdvice("AnnotationMatchingPointcut advice")));

		pf.setTarget(new TestBean());

		TestBean testBean = (TestBean) pf.getProxy();
		testBean.annotadedTestMethod("AnnotationMatchingPointcut annotated test");
	}
	
	private static void runRegexMatchingPointcut() {
		ProxyFactory pf = new ProxyFactory();
		JdkRegexpMethodPointcut rmp = new JdkRegexpMethodPointcut();
		rmp.setPattern(".*tM.*");
		pf.addAdvisor(new DefaultPointcutAdvisor(rmp,
				new AroundAdvice("JdkRegexpMethodPointcut advice")));

		pf.setTarget(new TestBean());

		TestBean testBean = (TestBean) pf.getProxy();
		testBean.testMethod("JdkRegexpMethodPointcut test");
	}
	
	private static void runNameMatchingPointcut() {
		ProxyFactory pf = new ProxyFactory();
		NameMatchMethodPointcut nmmp = new NameMatchMethodPointcut();
		nmmp.addMethodName("testMethod");
		pf.addAdvisor(new DefaultPointcutAdvisor(nmmp,
				new AroundAdvice("NameMatchMethodPointcut advice")));

		pf.setTarget(new TestBean());

		TestBean testBean = (TestBean) pf.getProxy();
		testBean.testMethod("NameMatchMethodPointcut test");
	}
	
	private static void runSimpleStaticPointcut() {
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(new DefaultPointcutAdvisor(new SimpleStaticPointcut("testMethod"),
				new AroundAdvice("SimpleStaticPointcut advice")));

		pf.setTarget(new TestBean());

		TestBean testBean = (TestBean) pf.getProxy();
		testBean.testMethod("SimpleStaticPointcut test");
	}

	private static void runSimpleDynamicPointcut() {
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(new DefaultPointcutAdvisor(new SimpleDynamicPointcut("SimpleDynamicPointcut test"),
				new AroundAdvice("SimpleDynamicPointcut advice")));

		pf.setTarget(new TestBean());

		TestBean testBean = (TestBean) pf.getProxy();
		testBean.testMethod("SimpleDynamicPointcut test");
	}
	
	private static void runFlowControllPointcut() {
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvisor(new DefaultPointcutAdvisor(
					new ControlFlowPointcut(
							AopPointcutsApplication.class, 
							"callTestMethod"),
				new AroundAdvice("ControlFlowPointcut advice")));

		pf.setTarget(new TestBean());

		TestBean testBean = (TestBean) pf.getProxy();
		new AopPointcutsApplication().callTestMethod(testBean, "ControlFlowPointcut adviced");
		testBean.testMethod("ControlFlowPointcut not adviced");	
	}
	
	private void callTestMethod(TestBean testBean, String arg) {
		testBean.testMethod(arg);
	}
}
