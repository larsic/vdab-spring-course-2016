package com.realdolmen.spring.domain;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class Visitor {
    private String name;
    private boolean grumpy;

    public Visitor(String name) {
        this(name, false);
    }

    public Visitor(String name, boolean grumpy) {
        this.name = name;
        this.grumpy = grumpy;
    }

    public String getName() {
        return name;
    }

    public boolean isGrumpy() {
        return grumpy;
    }

    public void orderMeal(Restaurant restaurant) {
        restaurant.serveMeal(this);
    }


    public void visit(Zoo zoo) {
        zoo.accept(this);
    }
}
