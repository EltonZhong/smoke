package com.ez.tools.validator.core;

import com.ez.tools.validator.annotations.IAnnotation;
import com.ez.tools.validator.core.flyweight.ValidatorContainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Validator {
    private ValidatorContainer container = new ValidatorContainer();

    public void validate(Object o) {
        Arrays.stream(o.getClass().getDeclaredFields()).forEach(field -> new FieldValidator(field, o).validate());
        Arrays.stream(o.getClass().getDeclaredMethods()).forEach(method -> new MethodValidator(method, o).validate());
    }

    private abstract class BaseValidator {
        Object fatherNode;
        Object valueToBeValidated;

        abstract protected void validate();

        abstract protected void validateWithAnnotation(Annotation annotation);

        boolean isVAnnotation(Annotation annotation) {
            return annotation.annotationType().getAnnotation(IAnnotation.class) == null;
        }

    }

    private class MethodValidator extends BaseValidator {
        private Method method;

        MethodValidator(Method method, Object father) {
            this.method = method;
            this.fatherNode = father;
        }

        @Override
        protected void validate() {
            valueToBeValidated = invokeMethod(method, fatherNode);
            Arrays
                    .stream(method.getDeclaredAnnotations())
                    .filter(this::isVAnnotation)
                    .forEach(this::validateWithAnnotation);
        }

        @Override
        protected void validateWithAnnotation(Annotation annotation) {
            String message = String.format(
                    "Validation failed with %s on Method %s",
                    annotation.annotationType(),
                    method.toGenericString()
            );
            container.validate(valueToBeValidated, annotation, message);
        }

        private Object invokeMethod(Method method, Object o) {
            method.setAccessible(true);
            try {
                return method.invoke(o);
            } catch (IllegalAccessException | InvocationTargetException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class FieldValidator extends BaseValidator {
        private Field field;

        FieldValidator(Field field, Object value) {
            this.field = field;
            this.fatherNode = value;
        }

        @Override
        protected void validate() {
            valueToBeValidated = getValue(field, fatherNode);
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
}
