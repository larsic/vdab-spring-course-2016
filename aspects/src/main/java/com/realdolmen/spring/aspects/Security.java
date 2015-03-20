package com.realdolmen.spring.aspects;

import com.realdolmen.spring.domain.EscapedAnimalException;
import com.realdolmen.spring.domain.Animal;
import com.realdolmen.spring.domain.Chimp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Security {
    @Around("execution(* *..Zoo.releaseAnimal(..)) && args(animal)")
    public Object guardZoo(ProceedingJoinPoint joinPoint, Animal animal) throws Throwable {
        if(animal instanceof Chimp) {
            joinPoint.proceed();
            throw new EscapedAnimalException(animal);
        } else {
            System.out.println();
            System.out.println("***********************************************");
            System.out.format("Preventing %s '%s' from escaping!%n", animal.type(), animal.getName());
            System.out.println("***********************************************");
            System.out.println(
                "     ||   ||     ||   ||\n" +
                "     ||   ||, , ,||   ||\n" +
                "     ||  (||/|/(\\||/  ||\n" +
                "     ||  ||| _'_`|||  ||\n" +
                "     ||   || o o ||   ||\n" +
                "     ||  (||  - `||)  ||\n" +
                "     ||   ||  =  ||   ||\n" +
                "     ||   ||\\___/||   ||\n" +
                "     ||___||) , (||___||\n" +
                "    /||---||-\\_/-||---||\\\n" +
                "   / ||--_||_____||_--|| \\\n" +
                "  (_(||)-| S123-45 |-(||)_)\n" +
                "|\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"\"|"
            );
            System.out.println("***********************************************");
            System.out.println();
            return null;
        }
    }
}
