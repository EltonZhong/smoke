package com.ez.tools.validator.core.flyweight;

import com.ez.tools.validator.annotations.Default;
import com.ez.tools.validator.annotations.VInt;
import com.ez.tools.validator.annotations.VNotNull;
import com.ez.tools.validator.annotations.VString;
import com.ez.tools.validator.core.flyweight.impl.IntegerValidator;
import com.ez.tools.validator.core.flyweight.impl.StringValidator;

import java.lang.annotation.Annotation;
import java.util.*;

public class BasicValidators {

    public List<Class<? extends Annotation>> toAnnotations;
    public List<BasicValidator> validators = new ArrayList<>();
    public Map<Class<? extends Annotation>, BasicValidator> map;

    void constructValidatorsMap() {
        toAnnotations = Arrays.asList(
                Default.class,
                VInt.class,
                VNotNull.class,
                VString.class
        );
        map = new HashMap<>();
        map.put(VInt.class, new IntegerValidator<VInt, Integer>());
        map.put(VString.class, new StringValidator());
    }

    BasicValidator getByAnnotation() {
        return null;
    }
}
