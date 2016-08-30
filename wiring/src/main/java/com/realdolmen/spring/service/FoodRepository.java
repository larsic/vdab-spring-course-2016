package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;

/**
 * Created by brandonstark on 26/08/16.
 */
public interface FoodRepository {
    public void addFoodForAnimalType(Class<? extends Animal> a, Food f);

    public Food findFoodForAnimalType(Class<? extends Animal> b);
}
