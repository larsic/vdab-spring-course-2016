package com.realdolmen.spring.blog.controllers;

import com.realdolmen.spring.blog.BlogApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BlogApplication.class)
@ActiveProfiles("test")
@WebAppConfiguration
public class HomeControllerTest {
    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = webAppContextSetup(context).build();
    }

    @Test
    public void homeControllerReturnsIndexPage() throws Exception {
        mvc.perform(get("/index"))
            .andExpect(status().isOk())
            .andExpect(view().name("index"))
            .andExpect(content().string(containsString("This is the homepage of the RealDolmen Blog.")));
    }
}
