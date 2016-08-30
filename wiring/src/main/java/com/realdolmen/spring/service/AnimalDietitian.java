package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by brandonstark on 26/08/16.
 */
public class AnimalDietitian implements FoodRepository{

    private Map<String, Food> feed = new HashMap<>();

    @Override
    public void addFoodForAnimalType(Class<? extends Animal> a, Food f) {
        feed.put(a.getName(),f);
    }

    @Override
    public Food findFoodForAnimalType(Class<? extends Animal> b) {
        return feed.get(b.getName());
    }
}
