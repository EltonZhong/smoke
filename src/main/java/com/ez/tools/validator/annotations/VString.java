package com.ez.tools.validator.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Notice: when the annotated field is null, just won't do any validation.
 */
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

    // Regexps
    String[] shouldMatch() default {};
    String[] shouldNotMatch() default {};
}
