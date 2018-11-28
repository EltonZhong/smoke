package com.ez.tools.validator.core.flyweight.impl;

import com.ez.tools.validator.annotations.VInt;
import com.ez.tools.validator.core.flyweight.BasicValidator;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntegerValidator<T extends VInt, V extends Integer> extends BasicValidator<T, V> {
    @Override
    public void with(T annotation) {
        this.annotation = annotation;
        if (value == null) {
            return;
        }

        shouldBe();
        shouldNotBe();
        greaterThan();
        lessThan();
        notZero();
    }

    private void shouldBe() {
        boolean isValueNotInShouldBes = Stream.of(annotation.shouldBe(), annotation.value())
                .flatMapToInt(Arrays::stream)
                .noneMatch(s -> value.equals(s));

        if (isValueNotInShouldBes) {
            fail();
        }
    }

    private void shouldNotBe() {
        if (Arrays.stream(annotation.shouldNotBe()).anyMatch(s -> value.equals(s))) {
            fail();
        }
    }

    private void greaterThan() {
        if (Arrays.stream(annotation.greaterThan()).anyMatch(it -> value.intValue() <= it)) {
            fail();
        }
    }

    private void lessThan() {
        if (Arrays.stream(annotation.lessThan()).anyMatch(it -> value.intValue() >= it)) {
            fail();
        }
    }

    private void notZero() {
        if (annotation.notZero()) {
            if (value.intValue() == 0) {
                fail();
            }
        }
    }
}
