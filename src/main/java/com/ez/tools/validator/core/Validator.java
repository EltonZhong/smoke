package com.ez.tools.validator.core;

import com.ez.tools.validator.core.detail.FieldValidator;
import com.ez.tools.validator.core.detail.MethodValidator;

import java.util.*;

public class Validator {
    public static void validate(Object o) {
        RecursiveHelper.recordValue(o);
        validateForFieldsAndMethods(o);
        RecursiveHelper.clean();
    }

    public static void validateSonRecursively(Object o) {
        if (RecursiveHelper.has(o)) {
            return;
        }
        validateForFieldsAndMethods(o);
        RecursiveHelper.recordValue(o);
    }

    private static void validateForFieldsAndMethods(Object o) {
        Arrays.stream(o.getClass().getDeclaredFields()).forEach(field -> new FieldValidator(field, o).validate());
        Arrays.stream(o.getClass().getDeclaredMethods()).forEach(method -> new MethodValidator(method, o).validate());
    }

    private static class RecursiveHelper {
        private static Set<Object> values = new HashSet<>();

        private static void recordValue(Object o) {
            values.add(o);
        }

        private static boolean has(Object o) {
            return values.contains(o);
        }

        private static void clean() {
            values = new HashSet<>();
        }
    }
}
