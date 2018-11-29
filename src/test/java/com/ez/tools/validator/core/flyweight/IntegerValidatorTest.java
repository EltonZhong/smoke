package com.ez.tools.validator.core.flyweight;

import com.ez.tools.validator.factory.dtos.DtoWithIntFields;
import com.ez.tools.validator.lib.ValidationTestBuilder;
import org.junit.Test;

public class IntegerValidatorTest {
    @Test
    public void shouldPassForFieldValueInShouldBe() {
        ValidationTestBuilder
                .setClass(DtoWithIntFields.class)
                .setFieldName("fieldShoudBeIn123")
                .setValue(1)
                .build();
    }

    @Test
    public void failWhenValueNotInShouldBe() {
        ValidationTestBuilder
                .setClass(DtoWithIntFields.class)
                .setFieldName("fieldShoudBeIn123")
                .setValue(4)
                .expectException(IllegalStateException.class)
                .build();
    }

    @Test
    public void failWhenValueInShouldNotBe() {
        ValidationTestBuilder
                .setClass(DtoWithIntFields.class)
                .setFieldName("fieldShouNotBe1234")
                .setValue(4)
                .expectException(IllegalStateException.class)
                .build();
    }

    @Test
    public void shouldPassWhenValueInValues() {
        ValidationTestBuilder
                .setClass(DtoWithIntFields.class)
                .setFieldName("valueShouldBe12")
                .setValue(1)
                .build();
    }

    @Test
    public void shouldFailWhenValueNotInValues() {
        ValidationTestBuilder
                .setClass(DtoWithIntFields.class)
                .setFieldName("valueShouldBe12")
                .setValue(3)
                .expectException(IllegalStateException.class)
                .build();
    }

    @Test
    public void shouldPassWhenValueGreaterThanAllGreater() {
        ValidationTestBuilder
                .setClass(DtoWithIntFields.class)
                .setFieldName("shouldBeGreaterThan1AndNagative2")
                .setValue(2)
                .build();
    }

    @Test
    public void shouldFailWhenValueNotGreaterThanAllGreater() {
        ValidationTestBuilder
                .setClass(DtoWithIntFields.class)
                .setFieldName("shouldBeGreaterThan1AndNagative2")
                .setValue(1)
                .expectException(IllegalStateException.class)
                .build();
    }

    @Test
    public void shouldPassWhenValueLessThanAllLess() {
        ValidationTestBuilder
                .setClass(DtoWithIntFields.class)
                .setFieldName("shouldBeLessThan122AndNagative100")
                .setValue(-101)
                .build();
    }

    @Test
    public void shouldFailWhenValueNotLessThanAllLess() {
        ValidationTestBuilder
                .setClass(DtoWithIntFields.class)
                .setFieldName("shouldBeLessThan122AndNagative100")
                .setValue(-100)
                .expectException(IllegalStateException.class)
                .build();
    }

    @Test
    public void willNotValidateWhenFieldIsNull() {
        ValidationTestBuilder
                .setClass(DtoWithIntFields.class)
                .setFieldName("shouldBeLessThan122AndNagative100")
                .setValue(null)
                .build();
    }
}
