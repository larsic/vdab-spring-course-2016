package com.realdolmen.spring.aspects;

import com.realdolmen.spring.domain.DefaultRestaurant;
import com.realdolmen.spring.domain.Restaurant;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Facilities {
    @DeclareParents(value = "com.realdolmen.spring.domain.Zoo+", defaultImpl = DefaultRestaurant.class)
    public Restaurant restaurant;
}
