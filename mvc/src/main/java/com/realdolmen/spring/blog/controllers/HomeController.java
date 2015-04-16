package com.realdolmen.spring.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by cda5732 on 16/04/2015.
 */
@Controller
@RequestMapping({"/", "/index"})
public class HomeController {
    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "index";
    }
}
