package com.ez.tools.validator.core.detail;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodValidator extends BaseValidator {
    private Method method;

    public MethodValidator(Method method, Object father) {
        this.method = method;
        this.rootNode = father;
    }

    @Override
    public void validate() {
        valueToBeValidated = invokeMethod(method, rootNode);
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
            throw new RuntimeException(String.format(
                    "Error occured when invoking method %s#%s",
                    method.getDeclaringClass().getName(),
                    method.getName()), e);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(String.format(
                    "Method  %s#%s should not contain any arguments",
                    method.getDeclaringClass().getName(),
                    method.getName()), e);
        }
    }
}
