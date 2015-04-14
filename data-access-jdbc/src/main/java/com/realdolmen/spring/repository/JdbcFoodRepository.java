package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.domain.MeatyFood;
import com.realdolmen.spring.domain.VegiFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

@Repository
public class JdbcFoodRepository implements FoodRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final RowMapper<Food> FOOD_MAPPER = (rs, i) -> {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        int calories = rs.getInt("calories");
        String foodClassName = rs.getString("food_class");
        String meatyFoodType = rs.getString("meaty_food_type");
        boolean fruit = rs.getBoolean("fruit");
        boolean vegetables = rs.getBoolean("vegetables");

        if (MeatyFood.class.getSimpleName().equals(foodClassName)) {
            return new MeatyFood(id, name, calories, meatyFoodType == null ? null : MeatyFood.Type.valueOf(meatyFoodType));
        } else {
            return new VegiFood(id, name, calories, fruit, vegetables);
        }
    };

    @Override
    public List<Food> findAllFood() {
        return jdbcTemplate.query("select * from food order by name", FOOD_MAPPER);
    }

    @Override
    public List<Food> findFoodForAnimalType(Animal.Type type) {
        return jdbcTemplate.query("select * from food f join animal_diet d on d.food_id = f.id where d.animal_type = ? order by f.name", FOOD_MAPPER, type.name());
    }

    @Override
    public Food findFoodById(int id) {
        return jdbcTemplate.queryForObject("select * from food where id = ?", FOOD_MAPPER, id);
    }

    @Override
    public void addFoodForAnimalType(Animal.Type animalType, Food food) {
        if(food instanceof VegiFood) {
            createFood(animalType, (VegiFood) food);
        } else {
            createFood(animalType, (MeatyFood) food);
        }
        addAnimalDiet(animalType, food);
    }

    private void createFood(Animal.Type animalType, VegiFood food) {
        jdbcTemplate.update("insert into food(id, name, calories, food_class, vegetables, fruit) values(?, ?, ?, ?, ?, ?)",
            food.getId(),
            food.getName(),
            food.getCalories(),
            food.getClass().getSimpleName(),
            food.isVegetables(),
            food.isFruit()
        );
    }

    private void createFood(Animal.Type animalType, MeatyFood food) {
        jdbcTemplate.update("insert into food(id, name, calories, food_class, meaty_food_type) values(?, ?, ?, ?, ?)",
            food.getId(),
            food.getName(),
            food.getCalories(),
            food.getClass().getSimpleName(),
            food.getType().name()
        );
    }

    private void addAnimalDiet(Animal.Type animalType, Food food) {
        jdbcTemplate.update("insert into animal_diet(animal_type, food_id) values(?, ?)", animalType.name(), food.getId());
    }

    @Override
    public void removeFood(Food food) {
        jdbcTemplate.update("delete from animal_diet where food_id = ?", food.getId());
        jdbcTemplate.update("delete from food where id = ?", food.getId());
    }
}
