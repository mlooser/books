package org.mlooser.learn.spring.library.service;

import org.mlooser.learn.spring.library.Book;
import org.springframework.context.annotation.Primary;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class InMemoryBookService implements BookService {
    private Map<String, Book> booksByIsbn = new HashMap<>();

    @Override
    @PreAuthorize("isAuthenticated()")
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

    @Override
    @PreAuthorize("@accessChecker.canDeleteBooks(authentication)")
    public void remove(String isbn){
        booksByIsbn.remove(isbn);
    }
}
