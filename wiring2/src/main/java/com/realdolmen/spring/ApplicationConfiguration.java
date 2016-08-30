package com.realdolmen.spring;

import com.realdolmen.spring.service.Zoo;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by cda5732 on 25/03/2015.
 */
@SpringBootApplication
public class ApplicationConfiguration {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ApplicationConfiguration.class).profiles("lars-prod").run();
        Zoo zoo = context.getBean(Zoo.class);
        // TODO make sure the following print out values from properties files
        System.out.println("Zoo name: " + zoo.getName());
        System.out.println("Nr. of Animals: " + zoo.countAnimals());
        System.out.println("Max Animals: ");
        System.out.println("Owner: ");
        System.out.println("Ticket Price: ");
        zoo.feedAnimals();
    }
}
