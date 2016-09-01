package com.realdolmen.spring;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.repository.AnimalRepository;
import com.realdolmen.spring.repository.FoodRepository;
import com.realdolmen.spring.repository.JpaAnimalRepository;
import com.realdolmen.spring.service.FoodDistributionService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ZooConfig.class).profiles("production").build().run(args);
        context.getBean(FoodDistributionService.class).feedAllAnimal();

        AnimalRepository fr = context.getBean(AnimalRepository.class);
        List<Animal> animals = fr.findAll();
        for ( Animal f: animals){
            System.out.println(f);

        }
    }
}
