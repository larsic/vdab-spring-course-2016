package com.realdolmen.spring_course.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by brandonstark on 26/08/16.
 */


@Configuration
@ComponentScan (basePackages = "be.lars")

public class MyConfiguration {
    @Bean
    public Quest blaQuest(){
        return new SlayDragonQuest();
    }
    @Bean
    public Knight fooKnight(){
        return new BraveKnight(blaQuest());
    }
}
