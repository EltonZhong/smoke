package com.ez.tools.validator.lib;

import com.ez.tools.validator.factory.dtos.User;
import org.junit.Test;

public class ValidationTestBuilderTest {
    @Test(expected = IllegalStateException.class)
    public void shouldFailWhenExpectFail() {
        ValidationTestBuilder
                .setClass(User.class)
                .setFieldName("fieldShoudBeIn123")
                .setValue("5555")
                .build();
    }

    @Test(expected = AssertionError.class)
    public void willThrowAssertExceptionWhenExpectAnotherException() {
        ValidationTestBuilder
                .setClass(User.class)
                .setFieldName("fieldShoudBeIn123")
                .setValue("5555")
                .expectException(IllegalArgumentException.class)
                .build();
    }

    @Test(expected = AssertionError.class)
    public void willThrowAssertExceptionWhenExpectExceptionButNotRecieved() {
        ValidationTestBuilder
                .setClass(User.class)
                .setFieldName("fieldShoudBeIn123")
                .setValue("1")
                .expectException(IllegalStateException.class)
                .build();
    }

    @Test
    public void willBeOkWhenDoesNotExpectExcpetion() {
        ValidationTestBuilder
                .setClass(User.class)
                .setFieldName("fieldShoudBeIn123")
                .setValue("1")
                .build();
    }
}
