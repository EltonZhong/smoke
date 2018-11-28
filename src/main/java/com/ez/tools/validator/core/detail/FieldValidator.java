package com.ez.tools.validator.core.detail;


import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class FieldValidator extends BaseValidator {
    private Field field;

    public FieldValidator(Field field, Object root) {
        this.field = field;
        this.rootNode = root;
    }

    @Override
    public void validate() {
        valueToBeValidated = getValue(field, rootNode);
        Arrays
                .stream(field.getDeclaredAnnotations())
                .filter(this::isVAnnotation)
                .forEach(this::validateWithAnnotation);
    }


    private Object getValue(Field field, Object o) {
        field.setAccessible(true);
        try {
            return field.get(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void validateWithAnnotation(Annotation annotation) {
        String message = String.format(
                "Validation failed with %s on Field %s",
                annotation.annotationType(),
                field.toGenericString()
        );
        container.validate(valueToBeValidated, annotation, message);
    }
}
