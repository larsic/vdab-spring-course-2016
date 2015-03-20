package com.realdolmen.spring.aspects;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BookKeeping {
    private int happyVisitorCount;
    private int unhappyVisitorCount;

    @AfterReturning(value = "execution(boolean *..Zoo.accept(..))", returning = "satisfied")
    public void trackVisitors(boolean satisfied) {
        System.out.println("Counting visitor.");
        if(satisfied) happyVisitorCount++; else unhappyVisitorCount++;
    }

    public int getHappyVisitorCount() {
        return happyVisitorCount;
    }

    public int getUnhappyVisitorCount() {
        return unhappyVisitorCount;
    }
}
