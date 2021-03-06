package org.mlooser.learn.spring.library.service;

import org.mlooser.learn.spring.library.Book;

import java.util.Optional;

public interface BookService {
    Iterable<Book> findAll();
    Book create(Book book);
    Optional<Book> find(String isbn);
    void remove(String isbn);
}
