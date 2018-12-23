package com.ez.tools.validator.factory.rules;

import com.ez.tools.validator.core.rules.IRule;

public class Rule1 implements IRule {
    @Override
    public void validate(Object o) {
        if (o instanceof DtoForRule1) {
            throw new IllegalStateException("Error1");
        }
        throw new IllegalArgumentException("Error2");
    }
}
