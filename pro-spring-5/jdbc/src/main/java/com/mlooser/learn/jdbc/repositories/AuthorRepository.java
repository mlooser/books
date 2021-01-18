package com.mlooser.learn.jdbc.repositories;

import java.util.List;

import com.mlooser.learn.jdbc.model.Author;

public interface AuthorRepository {
	Author save(Author author);
	Author findById(Long id);
	List<Author> findByFirstName(String firstName);
	List<Author> findAll();
	List<Author> findAllWithBooks();
}
