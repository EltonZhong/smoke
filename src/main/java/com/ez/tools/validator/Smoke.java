package com.ez.tools.validator;

import static com.ez.tools.validator.core.Validator.getValidator;

public class Smoke {
    public static void validate(Object o) {
        getValidator().validate(o);
    }
}
