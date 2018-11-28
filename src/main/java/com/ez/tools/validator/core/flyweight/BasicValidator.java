package com.ez.tools.validator.core.flyweight;

import org.apache.commons.lang3.Validate;

import java.lang.annotation.Annotation;

public abstract class BasicValidator<T extends Annotation, V> {
    protected T annotation;
    protected V value = null;
    private String errorMessage = null;

    BasicValidator<T, V> validate(V o) {
        value = o;
        return this;
    }

    BasicValidator<T, V> whenFail(String message) {
        errorMessage = message;
        return this;
    }

    public abstract void with(T annotation);

    protected void fail() {
        Validate.validState(false, errorMessage);
    }
}
