package com.ez.tools.validator.lib;

import com.ez.tools.validator.core.detail.FieldValidator;
import com.ez.tools.validator.core.detail.MethodValidator;
import org.junit.Assert;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ValidationTestBuilder {
    private Class clz;
    private Class<? extends Exception> expectedExceptionClass;
    private String fieldName;
    private Object value;

    private Object rootNode;
    private Field field;

    public static ValidationTestBuilder setClass(Class clz) {
        ValidationTestBuilder builder = new ValidationTestBuilder();
        builder.clz = clz;
        return builder;
    }

    public ValidationTestBuilder setFieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public ValidationTestBuilder setValue(Object value) {
        this.value = value;
        return this;
    }

    public ValidationTestBuilder expectException(Class<? extends Exception> expectedExceptionClass) {
        this.expectedExceptionClass = expectedExceptionClass;
        return this;
    }

    public void build() {
        setValueAndPrepare();
        if (this.expectedExceptionClass != null) {
            validateFieldAndRecieveException(expectedExceptionClass);
            validateMethodAndRecieveException(expectedExceptionClass);
            return;
        }
        validateForMethod();
        validateForField();
    }

    private void validateFieldAndRecieveException(Class<? extends Exception> excepClz) {
        try {
            validateForField();
        } catch (Exception e) {
            if (excepClz.isInstance(e)) {
                return;
            }
            Assert.fail(String.format(
                    "Expect excpetion %s to occur, but got %s",
                    excepClz.getName(), e.getClass().getName())
            );
        }

        Assert.fail(String.format(
                "Expect excpetion %s to occur, but you did not get what you want",
                excepClz.getName())
        );
    }

    private void validateMethodAndRecieveException(Class<? extends Exception> excepClz) {
        try {
            validateForMethod();
        } catch (Exception e) {
            if (excepClz.isInstance(e)) {
                return;
            }
        }

        Assert.fail(String.format(
                "Expect excpetion  %s occurs but does not get what you want",
                excepClz.getName())
        );
    }

    private void setValueAndPrepare() {
        try {
            rootNode = clz.newInstance();
            field = clz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(rootNode, value);
        } catch (NoSuchFieldException | IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    private void validateForField() {
        new FieldValidator(field, rootNode).validate();
    }

    private void validateForMethod() {
        Method method = null;
        try {
            method = clz.getDeclaredMethod(getGetterName(fieldName));
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        new MethodValidator(method, rootNode).validate();
    }

    private String getGetterName(String fieldName) {
        return "get" + String.valueOf(fieldName.charAt(0)).toUpperCase() + fieldName.substring(1);
    }

}
