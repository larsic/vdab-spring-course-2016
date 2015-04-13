package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;

/**
 * Created by cda5732 on 13/04/2015.
 */
public interface FoodRepository {
    void addFoodForAnimalType(Animal animal, Food food);
    Food findFoodForAnimalType(Animal animal);
}
