package org.mlooser.learn.spring.library.controller;

import org.mlooser.learn.spring.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {

    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books.html")
    public String getAllBooks(Model model){
        model.addAttribute("books", bookService.findAll());
        return "books/list";
    }

    @GetMapping(value = "/books.html", params = "isbn")
    public String getBook(@RequestParam("isbn") String isbn, Model model){
        bookService
                .find(isbn)
                .ifPresent(book->model.addAttribute("book", book));

        return "books/details";
    }
}
