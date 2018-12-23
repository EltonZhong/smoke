package com.ez.tools.validator.core.detail;

import com.ez.tools.validator.Smoke;
import org.junit.Test;

public class MethodValidatorTest {
    @Test
    public void smokeTest() {
        TestDto dto = new TestDto();
        Smoke.validate(dto);
    }
}
