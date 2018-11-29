package com.ez.tools.validator.core.flyweight;

import com.ez.tools.validator.factory.dtos.User;
import com.ez.tools.validator.lib.ValidationTestBuilder;
import org.junit.Test;

public class NotNullValidator {

    @Test
    public void shouldThrowExceptionWhenNotNullFieldIsNull() {
        ValidationTestBuilder
                .setClass(User.class)
                .setValue(null)
                .expectException(IllegalStateException.class)
                .setFieldName("notNullField")
                .build();
    }

    @Test
    public void shouldPassWhenNotNullFieldIsNotNull() {
        ValidationTestBuilder
                .setClass(User.class)
                .setValue(new User())
                .setFieldName("notNullField")
                .build();
    }
}
