package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.domain.Author;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class AuthorControllerTest extends AbstractControllerTest {
    @Test
    public void authorsDisplaysList() throws Exception {
        when(repository.findAll()).thenReturn(dummyAuthors());
        mvc.perform(get("/authors")).andExpect(model().attributeExists("authorList"));
        mvc.perform(get("/authors")).andExpect(model().attribute("authorList", dummyAuthors()));
    }

    private List<Author> dummyAuthors() {
        return Arrays.asList(
            new Author("email1", "username1", "password1"),
            new Author("email2", "username2", "password2")
        );
    }

    @Test
    public void removePropagatesToRepositoryDelete() throws Exception {
        long id = 1L;
        mvc.perform(get("/authors/{id}/remove", id));
        verify(repository).delete(id);
    }
}
