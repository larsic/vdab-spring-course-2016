package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.domain.Kibble;
import org.springframework.stereotype.Repository;

/**
 * Created by cda5732 on 14/04/2015.
 */
@Repository
@com.realdolmen.spring.annotations.Kibble
public class KibbleFoodRepositoryImpl implements FoodRepository {
    @Override
    public void addFoodForAnimalType(Class<? extends Animal> c, Food food) {

    }

    @Override
    public Food findFoodForAnimalType(Class<? extends Animal> c) {
        return new Kibble("Generic Tricatel Kibble");
    }
}
