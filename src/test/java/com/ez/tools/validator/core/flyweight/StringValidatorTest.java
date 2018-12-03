package com.ez.tools.validator.core.flyweight;

import com.ez.tools.validator.factory.dtos.User;
import com.ez.tools.validator.lib.ValidationTestBuilder;
import org.junit.Test;

public class StringValidatorTest {
    @Test
    public void shouldPassForFieldValueInShouldBe() {
        ValidationTestBuilder
                .setClass(User.class)
                .setFieldName("fieldShoudBeIn123")
                .setValue("1")
                .build();
    }

    @Test
    public void failWhenValueNotInShouldBe() {
        ValidationTestBuilder
                .setClass(User.class)
                .setFieldName("fieldShoudBeIn123")
                .setValue("4")
                .expectException(IllegalStateException.class)
                .build();
    }

    @Test
    public void failWhenValueInShouldNotBe() {
        ValidationTestBuilder
                .setClass(User.class)
                .setFieldName("fieldShouNotBe1234")
                .setValue("4")
                .expectException(IllegalStateException.class)
                .build();
    }

    @Test
    public void shouldPassWhenValueInValues() {
        ValidationTestBuilder
                .setClass(User.class)
                .setFieldName("valueShouldBe12")
                .setValue("1")
                .build();
    }

    @Test
    public void shouldFailWhenValueNotInValues() {
        ValidationTestBuilder
                .setClass(User.class)
                .setFieldName("valueShouldBe12")
                .setValue("3")
                .expectException(IllegalStateException.class)
                .build();
    }

    @Test
    public void shouldPassWhenValueContainsAllshouldContain() {
        ValidationTestBuilder
                .setClass(User.class)
                .setFieldName("shouldContain_abc_And_123")
                .setValue("adadabcadadad123")
                .build();
    }

    @Test
    public void shouldFailWhenValueDoesNotContainAllshouldContain() {
        ValidationTestBuilder
                .setClass(User.class)
                .setFieldName("shouldContain_abc_And_123")
                .setValue("aadaaaaaa1122222")
                .expectException(IllegalStateException.class)
                .build();
    }

    @Test
    public void shouldPassWhenValueDoesNotContainShouldNotContain() {
        ValidationTestBuilder
                .setClass(User.class)
                .setFieldName("shouldNotContain_abc_And_123")
                .setValue("aadaaaaaa1122222")
                .build();
    }

    @Test
    public void shouldFailWhenValueContainsShouldNotContain() {
        ValidationTestBuilder
                .setClass(User.class)
                .setFieldName("shouldNotContain_abc_And_123")
                .setValue("abcadaddadadda")
                .expectException(IllegalStateException.class)
                .build();
    }

    @Test
    public void willNotValidateWhenFieldIsNull() {
        ValidationTestBuilder
                .setClass(User.class)
                .setFieldName("shouldNotContain_abc_And_123")
                .setValue(null)
                .build();
    }

    @Test
    public void willValidateAndPassForShouldMatchValue() {
        ValidationTestBuilder
                .setClass(User.class)
                .setValue("1abc12def34")
                .setFieldName("shouldMatchAbcAndDef")
                .build();
    }

    @Test
    public void willValidateAndFailForShouldMatchValueMissMatch() {
        ValidationTestBuilder
                .setClass(User.class)
                .setValue("1abc12d1ef34")
                .setFieldName("shouldMatchAbcAndDef")
                .expectException(IllegalStateException.class)
                .build();
        ValidationTestBuilder
                .setClass(User.class)
                .setValue("abcdef34")
                .setFieldName("shouldMatchAbcAndDef")
                .expectException(IllegalStateException.class)
                .build();
    }

    @Test
    public void willValidateAndPassForShouldNotMatchValue() {
        ValidationTestBuilder
                .setClass(User.class)
                .setValue("1abbc12ddeef34")
                .setFieldName("shouldNotMatchAbcAndDef")
                .build();
    }

    @Test
    public void willValidateAndFailForShouldNotMatchValueMissMatch() {
        ValidationTestBuilder
                .setClass(User.class)
                .setValue("1abc12def34")
                .setFieldName("shouldNotMatchAbcAndDef")
                .expectException(IllegalStateException.class)
                .build();
        ValidationTestBuilder
                .setClass(User.class)
                .setValue("abc12def34")
                .setFieldName("shouldNotMatchAbcAndDef")
                .expectException(IllegalStateException.class)
                .build();
    }

    @Test
    public void testForEmailField() {
        ValidationTestBuilder
                .setClass(User.class)
                .setValue("1136154955@")
                .setFieldName("email")
                .expectException(IllegalStateException.class)
                .build();
        ValidationTestBuilder
                .setClass(User.class)
                .setValue("1154955@qq.com")
                .setFieldName("email")
                .build();
    }
}
