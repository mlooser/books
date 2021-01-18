package org.mlooser.learn.spring.library;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class AccessChecker {
    public boolean canDeleteBooks(Authentication authentication) {
        return authentication.getName().equals("admin2");
    }

}
