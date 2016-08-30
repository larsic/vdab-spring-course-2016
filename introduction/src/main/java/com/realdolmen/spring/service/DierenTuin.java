package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brandonstark on 26/08/16.
 */
public class DierenTuin implements Zoo {

    private String name;
    private List<Animal> animals = new ArrayList<>();

    public DierenTuin(String name){ this.name = name;}

    @Override
    public void addAnimal(Animal a) {
        animals.add(a);
    }

    @Override
    public void releaseAnimal(Animal a) {
        animals.remove(a);
    }


    public void releaseAnimalByName(String name) {
        Animal c = null;
        for(Animal a: animals) {
            if (a.getName().equals(name)){

               c = a;

            }
        }
        animals.remove(c);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int countAnimals() {
        return animals.size();
    }


}
