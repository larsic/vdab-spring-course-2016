package com.realdolmen.spring.config;

import com.realdolmen.spring.domain.*;
import com.realdolmen.spring.repository.FoodRepository;
import com.realdolmen.spring.repository.FoodRepositoryImpl;
import com.realdolmen.spring.service.PairiDaiza;
import com.realdolmen.spring.service.Zoo;
import org.springframework.context.annotation.*;

/**
 * Created by cda5732 on 14/04/2015.
 */
@Configuration
// TODO load test properties
@PropertySource("classpath:/Zooimpl-test.properties")
// TODO configure a profile
@Profile("lars-test")

// TODO use component scanning
@ComponentScan(basePackages = "com.realdolmen.spring")
public class TestConfig {
    @Bean
    public Zoo zoo() {
        Zoo zoo = new PairiDaiza();
        zoo.addAnimal(new Tiger("Bengal Tiger"));
        zoo.addAnimal(new Elephant("Indian Elephant"));
        zoo.addAnimal(new Bear("Brown Bear"));
        return zoo;
    }

    @Bean
    public FoodRepository repo() {
        FoodRepository r = new FoodRepositoryImpl();
        r.addFoodForAnimalType(Tiger.class, new Kibble());
        return r;
    }

   // TODO configure the properties loader


}
