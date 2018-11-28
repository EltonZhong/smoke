package com.ez.tools.validator.core.flyweight.impl;

import com.ez.tools.validator.annotations.VNotNull;
import com.ez.tools.validator.core.flyweight.BasicValidator;
import org.apache.commons.lang3.Validate;

import java.lang.annotation.Annotation;

public class NotNullValidator<T extends Annotation, V> extends BasicValidator<T, V> {
    @Override
    public void with(T annotation) {
        this.annotation =  annotation;
        Validate.notNull(value);
    }
}
