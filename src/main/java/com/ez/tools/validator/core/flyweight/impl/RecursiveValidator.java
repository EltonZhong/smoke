package com.ez.tools.validator.core.flyweight.impl;

import com.ez.tools.validator.core.Validator;
import com.ez.tools.validator.core.flyweight.BasicValidator;

import java.lang.annotation.Annotation;

public class RecursiveValidator extends BasicValidator {

    @Override
    public void with(Annotation annotation) {
        if (value == null) {
            return;
        }

        Validator.validateSonRecursively(value);
    }
}
