package com.ez.tools.validator.core.flyweight;

import com.ez.tools.validator.annotations.VInt;
import com.ez.tools.validator.core.flyweight.impl.IntegerValidator;
import org.junit.Test;

public class IntegerValidatorTest {
    @Test
    public void testInteger() {
        IntegerValidator<VInt, Integer> validator = new IntegerValidator();
    }
}
