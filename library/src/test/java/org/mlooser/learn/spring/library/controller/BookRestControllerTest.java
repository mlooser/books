package org.mlooser.learn.spring.library.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mlooser.learn.spring.library.Book;
import org.mlooser.learn.spring.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BookRestController.class)
@WithMockUser
public class BookRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void getAllBooksTest() throws Exception {

        when(bookService.findAll())
                .thenReturn(Arrays.asList(
                        new Book("t1", "i1", "a1"),
                        new Book("t2", "i2", "a2")
                ));

        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/api/books")
                                .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[*].isbn", containsInAnyOrder("i1", "i2")))
                .andExpect(jsonPath("$[*].title", containsInAnyOrder("t1", "t2")));
    }

    @Test
    public void getBook404Test() throws Exception {
        when(bookService.find(anyString()))
                .thenReturn(Optional.empty());

        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/api/books/123")
                                .with(csrf()))
                .andExpect(status().isNotFound());
    }

    @Test
    public void getBookTest() throws Exception {
        when(bookService.find("i1"))
                .thenReturn(Optional.of(new Book("t1", "i1", "a1")));

        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/api/books/i1")
                                .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isbn", equalTo("i1")))
                .andExpect(jsonPath("$.title", equalTo("t1")));
    }
}
