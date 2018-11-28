package com.ez.tools.validator.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@IAnnotation
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface VString {
    boolean notEmpty() default false;
    String shouldNotBe();
    String shouldBe();
    String[] shouldNotIn();
    String[] shouldBeIn();
    String value();
}
