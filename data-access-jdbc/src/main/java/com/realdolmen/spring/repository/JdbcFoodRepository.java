package com.realdolmen.spring.repository;

import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Food;
import com.realdolmen.spring.domain.MeatyFood;
import com.realdolmen.spring.domain.VegiFood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public class JdbcFoodRepository implements FoodRepository{

    @Autowired
    private JdbcTemplate jt;

    private RowMapper<Food> frm = (rs, i) -> {

        Food f = null;
        String name = rs.getString("name");
        int calories = rs.getInt("calories");
        int id = rs.getInt("id");

        if (rs.getString("food_class").equals("MeatyFood")) {
            MeatyFood.Type type = MeatyFood.Type.valueOf(rs.getString("meaty_food_type"));
            f = new MeatyFood(id, name, calories, type);

        } else {
            boolean fruit = rs.getBoolean("fruit");
            boolean vegetables = rs.getBoolean("vegetables");
            f = new VegiFood(id, name, calories, fruit, vegetables);
        }
        return f;

    };

    @Override
    public Food findFoodById(int id) {


        return jt.queryForObject("select * from food where id=?", frm, id);
    }

    @Override
    public List<Food> findAllFood() {

        return jt.query("select * from food ", frm);
    }

    @Override
    public List<Food> findFoodForAnimalType(Animal.Type type) {
        return jt.query("select * from animal_diet as a join food as f on f.id = a.food_id where a.animal_type=? order by f.name", frm, type.name());
    }

    @Override
    public void addFoodForAnimalType(Animal.Type animalType, Food food) {

        String meatyFoodType = null;
        boolean fruit = false;
        boolean vegetables = false;
        if(food instanceof MeatyFood){
            meatyFoodType = ((MeatyFood) food).getType().name();
        } else {
            fruit = ((VegiFood) food).isFruit();
            vegetables = ((VegiFood) food).isVegetables();

        }

        jt.update("INSERT into food (id, name, calories, food_class, meaty_food_type, fruit, vegetables) " +
                "           values(?,?,?,?,?,?,?)",
                food.getId(),
                food.getName(),
                food.getCalories(),
                food.getClass().getSimpleName(),
                meatyFoodType,
                fruit,
                vegetables

                );

        jt.update("insert into animal_diet(animal_type, food_id) values(?,?)",
        animalType.name(),
        food.getId()
        );
    }

    @Override
    public void removeFood(Food food) {

        jt.update("delete from animal_diet where animal_diet.food_id=?", food.getId());
        jt.update("delete from food where food.id=?", food.getId());



    }
    // TODO: Inject a reference to your JdbcTemplate

    // TODO: Implement findAllFood() and create a RowMapper to make this easier!

    // TODO: Implement findFoodById() and reuse your RowMapper

    // TODO: Implement findFoodForAnimalType()

    // TODO: Implement removeFood()
}
