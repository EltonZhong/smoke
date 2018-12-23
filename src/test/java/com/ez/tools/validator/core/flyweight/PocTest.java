package com.ez.tools.validator.core.flyweight;

import com.ez.tools.validator.Smoke;
import com.ez.tools.validator.annotations.VNotNull;
import com.ez.tools.validator.annotations.VRule;
import com.ez.tools.validator.factory.dtos.User;
import org.junit.Assert;
import org.junit.Test;

public class PocTest {

    @Test(expected = IllegalStateException.class)
    public void poc() {
        User user = new User();
        user.age = 10;
        user.name = "12";
        Smoke.validate(user);
    }

    @Test
    public void classes() {
        B b = new B();
        Assert.assertNotNull(b.getClass());
        Assert.assertEquals(
                b.getClass().getSuperclass().getInterfaces()[0].getAnnotations()[0].annotationType(),
                VRule.class
        );
    }

    @VRule
    interface I {}
    class A implements I {}
    private class B extends A {}
}
