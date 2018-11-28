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
    String[] shouldNotBe() default {};
    String[] shouldBe() default {};
    String[] shouldContain() default {};
    String[] shouldNotContain() default {};

    // Same as should be
    String[] value() default {};
}
