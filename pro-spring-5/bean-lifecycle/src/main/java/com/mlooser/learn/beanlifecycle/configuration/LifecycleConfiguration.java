/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mlooser.learn.beanlifecycle.configuration;

import com.mlooser.learn.beanlifecycle.beans.LifecycleAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author MarcinLusa
 */
@Configuration
public class LifecycleConfiguration {
    
    @Bean(initMethod = "initBean", destroyMethod = "destroyBean")
    LifecycleAware testLifecycleBean(){
        return new LifecycleAware();
    }
}
