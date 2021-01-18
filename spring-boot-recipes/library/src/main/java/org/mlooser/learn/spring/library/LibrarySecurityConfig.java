package org.mlooser.learn.spring.library;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class LibrarySecurityConfig
        extends WebSecurityConfigurerAdapter
        implements WebMvcConfigurer {

    @Autowired
    private DataSource dataSource;

    public LibrarySecurityConfig(){
        super(true);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry
                .addViewController("/login.html")
                .setViewName("login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetails adminUser = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("aaa")
                .authorities("ADMIN","USER")
                .build();

        UserDetails normalUser = User.withDefaultPasswordEncoder()
                .username("normal")
                .password("nnn")
                .authorities("USER")
                .build();

        UserDetails disabledUSer = User.withDefaultPasswordEncoder()
                .username("dnormal")
                .password("nnn")
                .authorities("USER")
                .build();

        auth.inMemoryAuthentication()
                .withUser(adminUser)
                .withUser(normalUser)
                .withUser(disabledUSer);

        auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.securityContext()
                .and().exceptionHandling()
                .and().servletApi()
                .and().httpBasic()
                .and().logout().logoutUrl("/perform_logout")
                .and().headers()
                .and().csrf()
                .and().anonymous().principal("guest").authorities("ROLE_GUEST")
                .and().rememberMe()
                .and().formLogin()
                    .loginPage("/login.html")
                    .defaultSuccessUrl("/books.html")
                    .failureUrl("/login.html?error=true").permitAll()
                .and().authorizeRequests()
                    .antMatchers(HttpMethod.GET,"/books*").hasAnyAuthority("USER", "ADMIN")
                    .antMatchers(HttpMethod.POST,"/books").hasAnyAuthority("USER","ADMIN")
                    .antMatchers(HttpMethod.DELETE,"/books*")
                        .access("hasAuthority('ADMIN') and @accessChacker.canDeleteBooks(authentication)");
    }
}
