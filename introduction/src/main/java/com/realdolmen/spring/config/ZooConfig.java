package com.realdolmen.spring.config;

import com.realdolmen.spring.domain.Bear;
import com.realdolmen.spring.domain.Elephant;
import com.realdolmen.spring.domain.Tiger;
import com.realdolmen.spring.service.DierenTuin;
import com.realdolmen.spring.service.Zoo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by brandonstark on 26/08/16.
 */
@Configuration
public class ZooConfig {

    @Bean
    public Zoo returnAZoo(){
        Zoo z = new DierenTuin("Plankendaal");
        z.addAnimal(new Tiger("Shere khan"));
        z.addAnimal(new Bear("Balou"));
        z.addAnimal(new Elephant("Dumbo"));
        z.releaseAnimalByName("Shere khan");
        return z;
    }
}
