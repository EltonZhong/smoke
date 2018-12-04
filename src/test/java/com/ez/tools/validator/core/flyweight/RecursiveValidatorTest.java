package com.ez.tools.validator.core.flyweight;

import com.ez.tools.validator.core.Validator;
import com.ez.tools.validator.factory.dtos.recursive.A;
import com.ez.tools.validator.factory.dtos.recursive.B;
import org.junit.Test;

public class RecursiveValidatorTest {

    @Test(expected = IllegalStateException.class)
    public void shouldThrowExceptionWhenRecursiveNotNullFieldIsNotOk() {
        A a = new A();
        a.b = new B();
        Validator.validate(a);
    }

    @Test
    public void shouldPassWhenRecursiveNotNullFieldIsOk() {
        A a = new A();
        B b = new B();
        a.b = b;
        b.notnull = "1";
        Validator.validate(a);
    }

    @Test
    public void recursiveTestJustWontCauseStackOverFlow() {
        B b = new B();
        A a = new A();
        a.b = b;
        b.a = a;
        b.notnull = "1";
        Validator.validate(a);
    }
}
