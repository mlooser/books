package org.mlooser.learn.spring.library;

import org.mlooser.learn.spring.library.service.BookService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
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
}
