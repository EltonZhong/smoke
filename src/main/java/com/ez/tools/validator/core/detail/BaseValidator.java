package com.ez.tools.validator.core.detail;

import com.ez.tools.validator.annotations.IAnnotation;
import com.ez.tools.validator.core.flyweight.ValidatorContainer;

import java.lang.annotation.Annotation;

public abstract class BaseValidator {
    ValidatorContainer container = ValidatorContainer.getInstance();
    Object rootNode;
    Object valueToBeValidated;

    public abstract void validate();

    abstract protected void validateWithAnnotation(Annotation annotation);

    boolean isVAnnotation(Annotation annotation) {
        return annotation.annotationType().getAnnotation(IAnnotation.class) != null;
    }
}
