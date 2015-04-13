package com.realdolmen.spring.service;

import com.realdolmen.spring.domain.Animal;

import java.util.List;

/**
 * Created by cda5732 on 13/04/2015.
 */
public interface FoodDistributionService {
    void feedAnimalsByType(List<Animal> animals);
}
