package com.mlooser.learn.profiles.services;

import org.springframework.stereotype.Component;

/**
 *
 * @author MarcinLusa
 */
@Component
public class MenuPrinter {
    
    private String restaurantName;
    private MenuProvider menuProvider;
    
    public MenuPrinter(String restaurantName, MenuProvider menuProvider) {
        this.restaurantName = restaurantName;
        this.menuProvider = menuProvider;
    }
    
    public String printMenu(){
        return restaurantName + " " + menuProvider.getMenu();
    }
}
