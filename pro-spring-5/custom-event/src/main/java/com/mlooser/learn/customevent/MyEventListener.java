package com.mlooser.learn.customevent;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author MarcinLusa
 */
public class MyEventListener implements ApplicationListener<MyEvent>, BeanNameAware{

    private final static String MSG_FORMAT = "MyEvent '%s' received in bean '%s'";
    private String beanName;
    
    @Override
    public void onApplicationEvent(MyEvent e) {
        String msg = String.format( MSG_FORMAT, e.getMessage(), beanName);
        System.out.println(msg);
    }

    @Override
    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

}
