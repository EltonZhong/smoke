package com.ez.tools.validator.core.flyweight.impl;


import com.ez.tools.validator.annotations.VString;
import com.ez.tools.validator.core.flyweight.BasicValidator;
import org.apache.commons.lang3.Validate;
import java.util.Arrays;

public class StringValidator<T extends VString, V extends String> extends BasicValidator<T, V> {
    private VString ano;

    @Override
    public void with(T annotation) {
        ano = annotation;
        this.notEmpty();
        this.shouldBe();
        this.shouldNotBe();
        this.shouldContain();
        this.shouldNotContain();
    }

    private void shouldBe() {
        if (Arrays.stream(ano.shouldBe()).noneMatch(s -> s.contentEquals(value))) {
            fail();
        }
    }

    private void shouldNotBe() {
        if (Arrays.stream(ano.shouldNotBe()).anyMatch(s -> s.contentEquals(value))) {
            fail();
        }
    }

    private void shouldContain() {
        if (!Arrays.stream(ano.shouldContain()).allMatch(s -> value.contains(s))) {
            fail();
        }
    }

    private void shouldNotContain() {
        if (Arrays.stream(ano.shouldNotContain()).anyMatch(s -> value.contains(s))) {
            fail();
        }
    }

    /**
     * TODO: validate chain
     */
    private void notEmpty() {
        if (ano.notEmpty()) {
            Validate.notEmpty(value);
        }

        if (!ano.notEmpty() && value == null) {
        }
    }
}
