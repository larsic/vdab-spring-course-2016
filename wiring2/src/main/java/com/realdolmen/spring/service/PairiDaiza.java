package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cda5732 on 25/03/2015.
 */



public class PairiDaiza implements Zoo {

    // TODO Add maxAnimalCount, ownerName and ticketPrice, and load from properties


    @Value("${Zoo.Name}")
    private String name;

    @Value("${Zoo.Maximal.Animal.Count}")
    private int maxAnimalCount;

    @Value("${Zoo.Owner.Name}")
    private String ownerName;

    @Value("${Zoo.Ticket.Price}")
    private double zooTicketPrice;

    private List<Animal> animals = new ArrayList<>();

    @Autowired
    private FoodDistributionService foodDistributionService;

    public PairiDaiza() {
    }

    public PairiDaiza(String name) {
        this.name = name;
    }

    @Override
    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    @Override
    public void releaseAnimal(Animal animal) {
        animals.remove(animal);
    }

    @Override
    public boolean accept(Visitor visitor) {
        System.out.println("Welcome visitor to " + getName());
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int countAnimals() {
        return animals.size();
    }

    @Override
    public void feedAnimals() {
        foodDistributionService.feedAnimalsByType(animals);
    }

    public double getZooTicketPrice() {
        return zooTicketPrice;
    }


    public String getZooOwnerName() {
        return ownerName;
    }

    public String getZooName() {
        return name;
    }
}
