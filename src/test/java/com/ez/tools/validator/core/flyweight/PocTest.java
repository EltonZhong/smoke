package com.ez.tools.validator.core.flyweight;

import com.ez.tools.validator.Smoke;
import com.ez.tools.validator.factory.dtos.User;
import org.junit.Test;

public class PocTest {

    @Test(expected = IllegalStateException.class)
    public void poc() {
        User user = new User();
        user.age = 10;
        user.name = "12";
        Smoke.validate(user);
    }
}
