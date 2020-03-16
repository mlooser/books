package org.mlooser.learn.spring.library.service;

import org.mlooser.learn.spring.library.Book;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class InMemoryBookService implements BookService {
    private Map<String, Book> booksByIsbn = new HashMap<>();

    @Override
    public Iterable<Book> findAll() {
        return booksByIsbn.values();
    }

    @Override
    public Book create(Book book) {
        booksByIsbn.put(book.getIsbn(), book);
        return book;
    }

    @Override
    public Optional<Book> find(String isbn) {
        return Optional.ofNullable(booksByIsbn.get(isbn));
    }
}
