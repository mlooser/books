package org.mlooser.learn.spring.library;

import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private String isbn;
    private List<String> authors;

    public Book() {
    }

    public Book(String title, String isbn, String... authors) {
        this.title = title;
        this.isbn = isbn;
        this.authors = Arrays.asList(authors);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", authors=" + authors +
                '}';
    }
}
