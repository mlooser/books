# General Spring
Contains projects created while reading "Pro Spring 5", to test various Spring features.

## JSR-330
Test of using JSR-330 annotations

## aop-advices 
Test of implemending before, after, after throw and around advices

## aop-pointcuts
Test of pointcuts defined with DynamicMethodMatcherPointcut, StaticMethodMatcherPointcutAdvisor, AnnotationMatchingPointcut, JdkRegexpMethodPointcut, NameMatchMethodPointcut

## bean-lifecycle
Hook to lifecycle events with 
  * InitializingBean, ApplicationContextAware, DisposableBean
  * @PostConstruct, @PreDestroy
  * @Bean(initMethod, destroyMethod)
  
## custom-event
Define and publish custom event

## profiles
Use profiles to inject proper bean implementation
