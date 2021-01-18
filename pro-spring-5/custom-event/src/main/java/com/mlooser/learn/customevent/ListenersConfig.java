package com.mlooser.learn.customevent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author MarcinLusa
 */
@Configuration
public class ListenersConfig {

    @Bean
    public MyEventListener listener1(){
        return new MyEventListener();
    }
    
    @Bean
    public MyEventListener listener2(){
        return new MyEventListener();
    }
}
