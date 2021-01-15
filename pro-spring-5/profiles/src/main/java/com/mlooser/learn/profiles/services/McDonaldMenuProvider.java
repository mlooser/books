package com.mlooser.learn.profiles.services;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author MarcinLusa
 */
public class McDonaldMenuProvider implements MenuProvider{

    @Override
    public Set<String> getMenu() {
       return  Stream.of("Big Mac","McRoyal","McChicken")
               .collect(Collectors.toSet());
    }
}
