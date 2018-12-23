package com.ez.tools.validator;

import com.ez.tools.validator.core.rules.IRule;

import java.util.Arrays;

import static com.ez.tools.validator.core.Validator.getValidator;

public class Smoke {
    public static void validate(Object o, IRule... rules) {
        getValidator().validate(o);
        Arrays.stream(rules).forEach(rule -> rule.validate(o));
    }
}
