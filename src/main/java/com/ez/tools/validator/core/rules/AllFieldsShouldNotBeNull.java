package com.ez.tools.validator.core.rules;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

public class AllFieldsShouldNotBeNull implements IRule {
    @Override
    public void validate(Object o) {
        Optional<Field> field = Arrays.stream(o.getClass().getDeclaredFields()).filter(f -> {
            try {
                f.setAccessible(true);
                return f.get(o) == null;
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }).findAny();

        if (field.isPresent()) {
            throw new IllegalStateException(
                    String.format("Field %s is null", field.get().toGenericString()));
        }
    }
}
