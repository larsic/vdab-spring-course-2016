package com.realdolmen.spring.annotations;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by cda5732 on 14/04/2015.
 */
@Target({ElementType.CONSTRUCTOR, ElementType.FIELD,
        ElementType.METHOD,
        ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Kibble {
}
