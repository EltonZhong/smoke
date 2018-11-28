package com.ez.tools.validator.core.flyweight;

import com.ez.tools.validator.core.Validator;
import org.junit.Test;

public class IntegerValidatorTest {

    @Test
    public void poc() {
        User user = new User();
        user.age = 10;
        user.name = "12";
        Validator validator = new Validator();
        validator.validate(user);
    }
}
