package com.ez.tools.validator.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface VInt {
    int[] shouldBe() default {};
    int[] shouldNotBe() default {};
    int[] greaterThan() default {};
    int[] lessThan() default {};
    boolean notZero() default false;

    // Should be
    int[] value() default {};
}
