package com.example.hexagonal.architecture.example.infrastructure.anotations;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Mapper {
    @AliasFor(annotation = Component.class)
    String value() default "";
}
