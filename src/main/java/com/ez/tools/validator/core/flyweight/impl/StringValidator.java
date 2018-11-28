package com.ez.tools.validator.core.flyweight.impl;


import com.ez.tools.validator.annotations.VString;
import com.ez.tools.validator.core.flyweight.BasicValidator;

import java.lang.annotation.Annotation;

public class StringValidator<T extends Annotation, V> extends BasicValidator<T, V> {
    @Override
    protected void with(T annotation) {
        VString ano = (VString) annotation;
    }
}
