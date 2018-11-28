package com.ez.tools.validator.core.flyweight;

import java.lang.annotation.Annotation;

public abstract class BasicValidator<T extends Annotation, V> {
    protected Object value = null;

    BasicValidator<T, V> validate(V o) {
        value = o;
        return this;
    }

    public abstract void with(T annotation);
}
