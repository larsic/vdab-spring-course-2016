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
public class JpaFoodRepository implements FoodRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public Food findFoodById(int id) {
        return em.find(Food.class, id);
    }



    @Override
    public List<Food> findAllFood()  {
        return em.createQuery("select f from Food f", Food.class).getResultList();
    }

    @Override
    public List<Food> findFoodForAnimalType(Animal.Type type) {
        return em.createQuery("select de.food from DietEntry as de where de.animalType= :theType order by de.food.name ", Food.class)
                .setParameter("theType", type)
                .getResultList();

    }

    @Override
    public void removeFood(Food food) {
        em.remove(food);
    }
    // TODO: Create a transactional repository bean implementing FoodRepository

    // TODO: implement findFoodById()

    // TODO: implement findAllFood()

    // TODO: implement findFoodForAnimalType()

    // TODO: implement removeFood()
}
