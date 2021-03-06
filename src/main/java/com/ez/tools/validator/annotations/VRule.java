package com.ez.tools.validator.annotations;

import com.ez.tools.validator.core.rules.IRule;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Notice: when the annotated field is null, just won't do any validation.
 */
@IAnnotation
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface VRule{

    // Same as should be
    Class<? extends IRule>[] value() default {};
}
