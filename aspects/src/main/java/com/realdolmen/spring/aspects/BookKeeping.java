package com.realdolmen.spring.aspects;

import com.realdolmen.spring.domain.Visitor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// TODO: Turn this class into a Spring Bean and an Aspect
@Component
@Aspect
public class BookKeeping {
    // TODO: Add an advice that advises the Zoo.accept(Visitor) method
    // TODO: Make sure the advice uses the return value of the the adviced method to keep track of happy and unhappy visitors

    private int counterhappy = 0;
    private int counterunhappy = 0;

    public int getHappyVisitorCount() {
        return counterhappy;
    }

    public int getUnhappyVisitorCount() {
        return counterunhappy;
    }



    @AfterReturning(value = "execution(* *.accept(com.realdolmen.spring.domain.Visitor))", returning="happiness")
    public void interceptAccept(boolean happiness){
        if(happiness == true){
            counterhappy++;


        } else {
            counterunhappy++;

        }

    }


}
