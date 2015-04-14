package com.realdolmen.spring;

import com.realdolmen.spring.service.Zoo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.util.Arrays;

/**
 * Created by cda5732 on 25/03/2015.
 */
@SpringBootApplication
public class ApplicationConfiguration {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ApplicationConfiguration.class).profiles("production").run();
        Zoo zoo = context.getBean(Zoo.class);
        System.out.println(zoo.getName());
        System.out.println("Nr. of Animals: " + zoo.countAnimals());
        System.out.println("Max Animals: " + zoo.getMaxAnimalCount());
        System.out.println("Owner: " + zoo.getOwnerName());
        System.out.println("Ticket Price: " + zoo.getTicketPrice());
        zoo.feedAnimals();
    }
}
