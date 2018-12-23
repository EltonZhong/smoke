package com.ez.tools.validator.core.flyweight.impl;

import com.ez.tools.validator.annotations.VRule;
import com.ez.tools.validator.core.flyweight.BasicValidator;
import com.ez.tools.validator.core.rules.IRule;

import java.util.Arrays;

public class RuleValidator<T extends VRule, V> extends BasicValidator<T, V> {
    @Override
    public void with(T annotation) {
        this.annotation = annotation;
        Class<? extends IRule>[] classes = annotation.value();
        Arrays.stream(classes).forEach(clazz -> {
            try {
                IRule rule = clazz.newInstance();
                rule.validate(this.value);
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
