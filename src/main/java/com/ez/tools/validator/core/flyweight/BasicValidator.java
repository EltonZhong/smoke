package com.ez.tools.validator.core.flyweight;

import java.lang.annotation.Annotation;

public abstract class BasicValidator<T extends Annotation, V> {
    private Object value = null;

    public BasicValidator<T, V> validate(V o) {
        value = o;
        return this;
    }

    protected abstract void with(T annotation);
}
