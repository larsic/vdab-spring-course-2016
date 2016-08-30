package com.realdolmen.spring.domain;

import com.realdolmen.spring.service.Zoo;

/**
 * Created by brandonstark on 26/08/16.
 */
public abstract class Animal {

    String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
