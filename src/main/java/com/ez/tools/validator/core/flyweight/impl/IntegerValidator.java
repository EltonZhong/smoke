package com.ez.tools.validator.core.flyweight.impl;

import com.ez.tools.validator.annotations.VInt;
import com.ez.tools.validator.core.flyweight.BasicValidator;

import java.lang.annotation.Annotation;

public class IntegerValidator<T extends Annotation, V> extends BasicValidator<T, V> {
    @Override
    public void with(T annotation) {
        VInt ano = (VInt) annotation;
    }
}
