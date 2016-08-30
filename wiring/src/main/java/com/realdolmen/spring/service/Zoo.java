package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Visitor;

/**
 * Created by cda5732 on 25/03/2015.
 */
public interface Zoo {
    void addAnimal(Animal animal);

    void releaseAnimal(Animal animal);

    boolean accept(Visitor visitor);

    String getName();

    int countAnimals();

    // TODO add method to feed animals

    void feedAnimals();
}
