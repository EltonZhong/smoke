package com.ez.tools.validator.core.flyweight.impl;

import com.ez.tools.validator.core.flyweight.BasicValidator;
import java.lang.annotation.Annotation;
import static com.ez.tools.validator.core.Validator.getValidator;

public class RecursiveValidator extends BasicValidator {

    @Override
    public void with(Annotation annotation) {
        if (value == null) {
            return;
        }

        getValidator().validateSonRecursively(value);
    }
}
