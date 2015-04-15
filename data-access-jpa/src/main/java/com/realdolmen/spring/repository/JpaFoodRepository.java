package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class JpaFoodRepository implements FoodRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Food findFoodById(int id) {
        return entityManager.find(Food.class, id);
    }

    @Override
    public List<Food> findAllFood() {
        return entityManager.createQuery("select f from Food f").getResultList();
    }

    @Override
    public List<Food> findFoodForAnimalType(Animal.Type type) {
        return entityManager.createQuery("select d.food from DietEntry d where d.animalType = :animalType order by d.food.name", Food.class)
            .setParameter("animalType", Animal.Type.bear)
            .getResultList();
    }

    @Override
    public void removeFood(Food food) {
        entityManager.remove(food);
    }
}
