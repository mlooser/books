/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlooser.learn.beanlifecycle.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author MarcinLusa
 */
public class LifecycleAware implements InitializingBean, ApplicationContextAware, DisposableBean{
    
    public void initBean(){
        System.out.println("LifecycleAware.initBean");
    }
    
    public void destroyBean(){
        System.out.println("LifecycleAware.destroyBean");
    }
    
    @PostConstruct
    public void postConstruct(){
        System.out.println("LifecycleAware.postConstruct");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("LifecycleAware.preDestroy");
    }
    
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifecycleAware.afterPropertiesSet");
    }

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        System.out.println("LifecycleAware.setApplicationContext");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("LifecycleAware.destroy");
    }
}
