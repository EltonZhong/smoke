package com.ez.tools.validator.core.flyweight.impl;


import com.ez.tools.validator.annotations.VString;
import com.ez.tools.validator.core.flyweight.BasicValidator;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringValidator<T extends VString, V extends String> extends BasicValidator<T, V> {
    @Override
    public void with(T annotation) {
        this.annotation = annotation;
        if (value == null) {
            return;
        }

        this.notEmpty();
        this.shouldBe();
        this.shouldNotBe();
        this.shouldContain();
        this.shouldNotContain();
        this.shouldMatch();
        this.shouldNotMatch();
    }

    private void shouldNotMatch() {
        boolean hasValueMatchRegex = Arrays.stream(annotation.shouldNotMatch())
                .anyMatch(regex -> value.matches(regex));
        if (hasValueMatchRegex) {
            fail();
        }
    }

    private void shouldMatch() {
        boolean hasValueNotMatchRegex = Arrays.stream(annotation.shouldMatch())
                .anyMatch(regex -> !value.matches(regex));
        if (hasValueNotMatchRegex) {
            fail();
        }
    }

    private void shouldBe() {
        if (annotation.shouldBe().length + annotation.value().length == 0) {
            return;
        }

        boolean isValueNotInShouldBes = Stream.of(annotation.shouldBe(), annotation.value())
                .flatMap(Arrays::stream)
                .noneMatch(s -> s.contentEquals(value));
        if (isValueNotInShouldBes) {
            fail();
        }
    }

    private void shouldNotBe() {
        if (Arrays.stream(annotation.shouldNotBe()).anyMatch(s -> s.contentEquals(value))) {
            fail();
        }
    }

    private void shouldContain() {
        if (!Arrays.stream(annotation.shouldContain()).allMatch(s -> value.contains(s))) {
            fail();
        }
    }

    private void shouldNotContain() {
        if (Arrays.stream(annotation.shouldNotContain()).anyMatch(s -> value.contains(s))) {
            fail();
        }
    }

    private void notEmpty() {
        if (!annotation.notEmpty()) {
            return;
        }
        if ("".contentEquals(value)) {
            fail();
        }
    }
}
