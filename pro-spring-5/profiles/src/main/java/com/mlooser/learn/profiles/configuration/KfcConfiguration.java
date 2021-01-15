package com.mlooser.learn.profiles.configuration;

import com.mlooser.learn.profiles.services.KFCMenuProvider;
import com.mlooser.learn.profiles.services.MenuProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 *
 * @author MarcinLusa
 */
@Configuration
@Profile({"default", "kfc"})
public class KfcConfiguration {
    
    @Bean
    public MenuProvider menuProvider(){
        return new KFCMenuProvider();
    }
    
    @Bean
    public String restaurantName(){
        return "KFC";
    }
}
