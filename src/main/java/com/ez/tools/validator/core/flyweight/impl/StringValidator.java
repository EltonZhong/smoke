package com.ez.tools.validator.core.flyweight.impl;


import com.ez.tools.validator.annotations.VString;
import com.ez.tools.validator.core.exceptions.ValidateFailException;
import com.ez.tools.validator.core.flyweight.BasicValidator;

import java.lang.annotation.Annotation;
import java.util.Arrays;

public class StringValidator<T extends Annotation, V> extends BasicValidator<T, V> {
    @Override
    public void with(T annotation) {
        VString ano = (VString) annotation;
        this.shouldBe(ano);
    }

    private void shouldBe(VString an) {
        if (Arrays.stream(an.shouldBe()).noneMatch(s -> s.equals(value))) {
            throw new ValidateFailException("none");
        }
    }
}
