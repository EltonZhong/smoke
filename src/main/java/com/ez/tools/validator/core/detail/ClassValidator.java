package com.ez.tools.validator.core.detail;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;

public class ClassValidator extends BaseValidator {
    private Object rootNode;

    public ClassValidator(Object o) {
        rootNode = o;
        this.valueToBeValidated = o;
    }

    @Override
    public void validate() {
        HashSet<Annotation> annotations = new HashSet<>();
        findAnnotations(rootNode.getClass(), annotations);
        annotations.stream().filter(this::isVAnnotation).forEach(this::validateWithAnnotation);
    }

    @Override
    protected void validateWithAnnotation(Annotation annotation) {
        String message = String.format(
                "Validation failed with %s on class %s",
                annotation.annotationType(),
                rootNode.getClass().toGenericString()
        );
        container.validate(valueToBeValidated, annotation, message);
    }

    private void findAnnotations(Class clazz, HashSet<Annotation> annotations) {
        annotations.addAll(Arrays.asList(clazz.getAnnotations()));
        Arrays.stream(clazz.getInterfaces()).forEach(interf -> findAnnotations(interf, annotations));
        if (clazz.getSuperclass() != null) {
            findAnnotations(clazz.getSuperclass(), annotations);
        }
    }
}
