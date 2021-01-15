package com.mlooser.learn.jdbc.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class Author {
	private Long id;
	private String firstName;
	private String lastName;
	private Set<Book> books = new HashSet<>();
	
	public void addBook(Book book) {
		books.add(book);
	}
	
}
