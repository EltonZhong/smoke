package com.ez.tools.validator.core;

import com.ez.tools.validator.Smoke;
import com.ez.tools.validator.annotations.VRule;
import com.ez.tools.validator.core.rules.AllFieldsShouldNotBeNull;
import org.junit.Assert;
import org.junit.Test;

public class RulesTest {

    @Test(expected = IllegalStateException.class)
    public void allTestDtoIsNullTest() {
        TestDto dto = new TestDto();
        Smoke.validate(dto);
    }

    @Test
    public void oneTestDtoIsNullTest() {
        TestDto dto = new TestDto();
        dto.a = null;
        dto.b = "";
        dto.c = "";
        try {
            Smoke.validate(dto);
        } catch (IllegalStateException e) {
            Assert.assertEquals(
                    e.getMessage(),
                    "Field java.lang.String com.ez.tools.validator.core.TestDto.a is null"
            );
        }
    }
}

@VRule(AllFieldsShouldNotBeNull.class)
class TestDto {
    String a = null;
    String b = null;
    String c = null;
}
