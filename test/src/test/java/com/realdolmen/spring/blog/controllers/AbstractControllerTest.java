package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.BlogApplication;
import com.realdolmen.spring.blog.dao.AuthorRepository;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.view.InternalResourceView;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BlogApplication.class)
@ActiveProfiles("test")
@WebAppConfiguration
public abstract class AbstractControllerTest {
    protected MockMvc mvc;

    @Autowired
    protected WebApplicationContext context;

    protected AuthorRepository repository = mock(AuthorRepository.class);

    @Before
    public void init() throws Exception {
        RegistrationController registrationController = new RegistrationController();
        AuthorController authorController = new AuthorController();
        registrationController.authorRepository = authorController.authorRepository = repository;
        mvc = standaloneSetup(registrationController, authorController).setSingleView(new InternalResourceView("/WEB-INF/views/index.html")).build();
    }
}
