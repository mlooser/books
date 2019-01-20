package com.mlooser.learn.profiles.configuration;

import com.mlooser.learn.profiles.services.McDonaldMenuProvider;
import com.mlooser.learn.profiles.services.MenuProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author MarcinLusa
 */
@Configuration
@Profile({"mc-donald"})
public class McDonaldConfiguration {

    @Bean
    public MenuProvider menuProvider(){
        return new McDonaldMenuProvider();
    }
    
    @Bean
    public String restaurantName(){
        return "McDonald";
    }
}
