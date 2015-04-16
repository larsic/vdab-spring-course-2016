package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.domain.Author;
import org.junit.Test;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

public class RegistrationControllerTest extends AbstractControllerTest {
    @Test
    public void formValidationFailure() throws Exception {
        mvc.perform(post("/register")
            .param("firstName", "Jimi")
            .param("lastName", "Hendrix")
            .param("email", "jimi.hendrix@hotmail.com")
            .param("userName", "")
            .param("password", "guitar123")
        ).andExpect(model().hasErrors());
    }

    @Test
    public void formValidationSuccess() throws Exception {
        mvc.perform(post("/register")
            .param("firstName", "Jimi")
            .param("lastName", "Hendrix")
            .param("email", "jimi.hendrix@hotmail.com")
            .param("userName", "jimbo")
            .param("password", "guitar123")
        ).andExpect(model().hasNoErrors());
        verify(repository).save(eq(expectedAuthor()));
    }

    private Author expectedAuthor() {
        Author author = new Author("jimi.hendrix@hotmail.com", "jimbo", "guitar123");
        author.setFirstName("Jimi");
        author.setLastName("Hendrix");
        return author;
    }
}
