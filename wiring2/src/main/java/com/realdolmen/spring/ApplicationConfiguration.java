package com.realdolmen.spring;

import com.realdolmen.spring.service.Zoo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Created by cda5732 on 25/03/2015.
 */
@SpringBootApplication
public class ApplicationConfiguration {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ApplicationConfiguration.class);
        Zoo zoo = context.getBean(Zoo.class);
        System.out.println(zoo.getName());
        System.out.println("Nr. of Animals: " + zoo.countAnimals());
        System.out.println("Max Animals: " + zoo.getMaxAnimalCount());
        System.out.println("Owner: " + zoo.getOwnerName());
        System.out.println("Ticket Price: " + zoo.getTicketPrice());
        zoo.feedAnimals();
    }
}
