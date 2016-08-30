package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;

/**
 * Created by brandonstark on 26/08/16.
 */
public interface Zoo {

    public void addAnimal(Animal a);
    public void releaseAnimal(Animal a);
    public void releaseAnimalByName(String name);
    public String getName();
    public int countAnimals();
}
