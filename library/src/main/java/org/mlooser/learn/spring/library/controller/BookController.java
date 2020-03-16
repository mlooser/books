package org.mlooser.learn.spring.library.controller;

import org.mlooser.learn.spring.library.Book;
import org.mlooser.learn.spring.library.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBook(@PathVariable("isbn") String isbn) {
        return bookService
                .find(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book, UriComponentsBuilder uriComponentsBuilder) {
        Book createdBook = bookService.create(book);

        URI newBookUri = uriComponentsBuilder
                .path("/books/{isbn}")
                .build(createdBook.getIsbn());

        return ResponseEntity
                .created(newBookUri)
                .body(createdBook);
    }
}
