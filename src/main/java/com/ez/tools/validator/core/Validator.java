package com.ez.tools.validator.core;

import com.ez.tools.validator.core.flyweight.ValidatorContainer;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Validator {
    private ValidatorContainer container = new ValidatorContainer();

    public void validate(Object o) {
        Arrays.stream(o.getClass().getDeclaredFields()).forEach(field -> validateField(field, o));
        Arrays.stream(o.getClass().getDeclaredMethods()).forEach(method -> validateMethod(method, o));
    }

    private void validateMethod(Method method, Object father) {
        Object value = invokeMethod(method, father);
        validateWithAnnotationsOnField(method.getDeclaredAnnotations(), value);
    }

    private void validateField(Field field, Object father) {
        Object value = getValue(field, father);
        validateWithAnnotationsOnField(field.getDeclaredAnnotations(), value);
    }

    private void validateWithAnnotationsOnField(Annotation[] annotations, Object value) {
        Arrays.stream(annotations).forEach(ano -> container.validate(value, ano));
    }

    private Object invokeMethod(Method method, Object o) {
        method.setAccessible(true);
        try {
            return method.invoke(o);
        } catch (IllegalAccessException| InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private Object getValue(Field field, Object o) {
        field.setAccessible(true);
        try {
            return field.get(o);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
