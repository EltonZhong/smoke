package com.ez.tools.validator.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@IAnnotation
@Retention(RetentionPolicy.RUNTIME)
public @interface VInt {
    int value();
    int greaterThan();
    int lessThan();
}
