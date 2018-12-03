package com.ez.tools.validator.core.detail;

import com.ez.tools.validator.core.Validator;
import org.junit.Test;

public class MethodValidatorTest {
    @Test
    public void smokeTest() {
        TestDto dto = new TestDto();
        Validator.validate(dto);
    }
}
