package org.mlooser.learn.spring.library.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mlooser.learn.spring.library.controller.HelloWorldController;
import org.mlooser.learn.spring.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloWorldController.class)
@WithMockUser
public class HelloWorldControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Test
    public void sayHelloTest() throws Exception {
        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/hello")
                                .with(csrf()))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello from Spring Boot 2"))
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN));
    }
}
