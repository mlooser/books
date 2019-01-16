package com.mlooser.learn.customevent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 *
 * @author MarcinLusa
 */
@Component
public class MyEventPublisher implements ApplicationContextAware {

    private ApplicationContext applicationContext;
    
    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.applicationContext = ac;
    }
    
    public void publish(String message){
        applicationContext.publishEvent( new MyEvent(this, message));
    }

}
