package com.ez.tools.validator.core;

import com.ez.tools.validator.Smoke;
import com.ez.tools.validator.factory.dtos.MixedDto;
import com.ez.tools.validator.factory.dtos.User;
import org.junit.Test;


public class ValidatorTest {

    @Test
    public void validateSmokeTest() {
        MixedDto mixedDto = new MixedDto();
        mixedDto.stringField = "1";
        mixedDto.anInt = 1;
        mixedDto.user = new User();
        Smoke.validate(mixedDto);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenStringValidationFail() {
        MixedDto mixedDto = new MixedDto();
        mixedDto.stringField = "";
        mixedDto.anInt = 1;
        mixedDto.user = new User();
        Smoke.validate(mixedDto);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenIntValidationFail() {
        MixedDto mixedDto = new MixedDto();
        mixedDto.stringField = "1";
        mixedDto.anInt = 0;
        mixedDto.user = new User();
        Smoke.validate(mixedDto);
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenNotNullValidationFail() {
        MixedDto mixedDto = new MixedDto();
        mixedDto.stringField = "1";
        mixedDto.anInt = 0;
        Smoke.validate(mixedDto);
    }

    @Test(expected = IllegalStateException.class)
    public void testThatMethodAnnotationShouldWork() {
        MixedDto mixedDto = new MixedDto();
        mixedDto.stringField = "1";
        mixedDto.anInt = 1;
        mixedDto.user = new User();
        mixedDto.stringForMethodTest = "2";
        Smoke.validate(mixedDto);
    }
}