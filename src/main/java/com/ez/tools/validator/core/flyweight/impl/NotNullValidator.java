package com.ez.tools.validator.core.flyweight.impl;

import com.ez.tools.validator.annotations.VNotNull;
import com.ez.tools.validator.core.flyweight.BasicValidator;

public class NotNullValidator<T extends VNotNull, V> extends BasicValidator<T, V> {
    @Override
    public void with(T annotation) {
        this.annotation =  annotation;
        if (value == null) {
            fail();
        }
    }
}
