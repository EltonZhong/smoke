package com.ez.tools.validator.core.flyweight.impl;

import com.ez.tools.validator.annotations.VRule;
import com.ez.tools.validator.core.flyweight.BasicValidator;

import java.lang.annotation.Annotation;

public class RuleValidator<T extends VRule, V> extends BasicValidator<T, V> {
    @Override
    public void with(T annotation) {
        this.annotation = annotation;
        String[] classes = annotation.value();
    }
}
