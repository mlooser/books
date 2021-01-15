package com.mlooser.learn.profiles.services;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author MarcinLusa
 */
public class KFCMenuProvider implements MenuProvider{

    @Override
    public Set<String> getMenu() {
       return  Stream.of("Zinger Burger","Longer","Mega Pocket")
               .collect(Collectors.toSet());
    }
}
