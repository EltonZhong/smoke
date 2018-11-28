package com.ez.tools.validator.core;

import com.ez.tools.validator.core.detail.FieldValidator;
import com.ez.tools.validator.core.detail.MethodValidator;

import java.util.Arrays;

public class Validator {
    public void validate(Object o) {
        Arrays.stream(o.getClass().getDeclaredFields()).forEach(field -> new FieldValidator(field, o).validate());
        Arrays.stream(o.getClass().getDeclaredMethods()).forEach(method -> new MethodValidator(method, o).validate());
    }
}
