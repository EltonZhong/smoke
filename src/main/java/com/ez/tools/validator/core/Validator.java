package com.ez.tools.validator.core;

import com.ez.tools.validator.core.detail.ClassValidator;
import com.ez.tools.validator.core.detail.FieldValidator;
import com.ez.tools.validator.core.detail.MethodValidator;

import java.util.*;

public class Validator {
    static ThreadLocal<Validator> validator = new ThreadLocal<>();
    private RecursiveHelper helper = new RecursiveHelper();

    public static Validator getValidator() {
        if (validator.get() == null) {
            validator.set(new Validator());
        }
        return validator.get();
    }

    public void validate(Object o) {
        helper.clean();
        helper.recordValue(o);
        validateFor(o);
    }

    public void validateSonRecursively(Object o) {
        if (helper.has(o)) {
            return;
        }
        helper.recordValue(o);
        validateFor(o);
    }

    private void validateFor(Object o) {
        validateForClass(o);
        validateForFields(o);
        validateForMethods(o);
    }

    private void validateForClass(Object o) {
        new ClassValidator(o).validate();
    }

    private void validateForFields(Object o) {
        Arrays.stream(o.getClass().getDeclaredFields()).forEach(field -> new FieldValidator(field, o).validate());
    }

    private void validateForMethods(Object o) {
        Arrays.stream(o.getClass().getDeclaredMethods()).forEach(method -> new MethodValidator(method, o).validate());
    }


    private static class RecursiveHelper {
        private Set<Object> values = new HashSet<>();

        private void recordValue(Object o) {
            values.add(o);
        }

        private boolean has(Object o) {
            return values.contains(o);
        }

        private void clean() {
            values = new HashSet<>();
        }
    }
}
