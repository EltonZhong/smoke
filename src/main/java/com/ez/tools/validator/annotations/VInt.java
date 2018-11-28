package com.ez.tools.validator.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Notice: when the annotated field is null, just won't do any validation.
 */
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
