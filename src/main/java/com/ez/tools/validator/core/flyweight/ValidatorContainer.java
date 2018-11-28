package com.ez.tools.validator.core.flyweight;

import com.ez.tools.validator.annotations.Default;
import com.ez.tools.validator.annotations.VInt;
import com.ez.tools.validator.annotations.VNotNull;
import com.ez.tools.validator.annotations.VString;
import com.ez.tools.validator.core.flyweight.impl.IntegerValidator;
import com.ez.tools.validator.core.flyweight.impl.NotNullValidator;
import com.ez.tools.validator.core.flyweight.impl.StringValidator;

import java.lang.annotation.Annotation;
import java.util.*;

public class ValidatorContainer {

    private Map<Class<? extends Annotation>, BasicValidator> map;

    public ValidatorContainer() {
        constructValidatorsMap();
    }

    private void constructValidatorsMap() {
        map = new HashMap<>();
        map.put(VInt.class, new IntegerValidator<VInt, Integer>());
        map.put(VString.class, new StringValidator());
        map.put(VNotNull.class, new NotNullValidator());
    }

    public void validate(Object value, Annotation an) {
        getByAnnotation(an).validate(value).with(an);
    }

    @SuppressWarnings("unchecked")
    private <V, T extends Annotation> BasicValidator<T, V> getByAnnotation(T annotation) {
        if (map.containsKey(annotation.annotationType())) {
            return map.get(annotation.annotationType());
        }
        throw new UnsupportedOperationException(
                String.format("Can not validate with annotation type %s", annotation.getClass()));
    }
}
