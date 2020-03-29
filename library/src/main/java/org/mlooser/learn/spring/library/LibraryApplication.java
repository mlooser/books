package org.mlooser.learn.spring.library;

import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mlooser.learn.spring.library.service.BookService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@SpringBootApplication
public class LibraryApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public ApplicationRunner booksInitializer(BookService bookService){
		return args->{
			bookService.create(
					new Book("Bible","111","Holly Gost"));

			bookService.create(
					new Book("God's General","222", "Robert Larson"));
		};
	}

	@Bean
	@Profile("prd")
	public TomcatServletWebServerFactory  tomcatServletWebServerFactory(){
		TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
		factory.addAdditionalTomcatConnectors(httpConnector());
		factory.addContextCustomizers(securityCustomizer());
		return factory;
	}

	private Connector httpConnector(){
		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(8443);
		return connector;
	}

	private TomcatContextCustomizer securityCustomizer(){
		return context -> {
			SecurityConstraint securityConstraint = new SecurityConstraint();
			securityConstraint.setUserConstraint("CONFIDENTAL");
			SecurityCollection securityCollection = new SecurityCollection();
			securityCollection.addPattern("/*");
			securityConstraint.addCollection(securityCollection);
			context.addConstraint(securityConstraint);
		};
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor(){
		return new LocaleChangeInterceptor();
	}

	@Bean
	public LocaleResolver localeResolver(){
		return new CookieLocaleResolver();
	}
}
