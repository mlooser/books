package org.mlooser.learn.spring.library.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mlooser.learn.spring.library.Book;
import org.mlooser.learn.spring.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = "spring.security.user.password=123")
public class BookRestControllerIntegrationTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private BookService bookService;

    //@Test
    public void getAllBooksTest() {
        when(bookService.findAll())
                .thenReturn(Arrays.asList(
                        new Book("t1", "i1", "a1"),
                        new Book("t2", "i2", "a2")
                ));

        ResponseEntity<Book[]> books = testRestTemplate
                .withBasicAuth("user", "123")
                .getForEntity("/api/books", Book[].class);

        assertThat(books.getStatusCode())
                .isEqualTo(HttpStatus.OK);

        assertThat(books.getBody())
                .hasSize(2);
    }
}
