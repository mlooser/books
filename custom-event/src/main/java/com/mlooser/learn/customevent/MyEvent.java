package com.mlooser.learn.customevent;

import org.springframework.context.ApplicationEvent;

/**
 *
 * @author MarcinLusa
 */
public class MyEvent extends ApplicationEvent {
    
    private String message;
    
    public MyEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
    
}
