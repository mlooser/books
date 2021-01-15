package com.mlooser.learn.JSR330;

import javax.inject.Inject;
import javax.inject.Named;
/**
 *
 * @author MarcinLusa
 */
@Named("messageProducer")
public class Jsr330MessageProducer implements MessageProducer{

    @Inject
    @Named("testMsg")
    private String message;

    @Override
    public String getMessage() {
       return message;
    }
    
     
}
