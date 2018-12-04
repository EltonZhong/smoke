package com.ez.tools.validator.factory.dtos.recursive;

import com.ez.tools.validator.annotations.VRecursive;

public class A {
    @VRecursive
    public B b = new B();

    @VRecursive
    public B getB() {
        return b;
    }

    /**
     * Useless but please just don't delete me
     */
    public double d() {
        return 1;
    }
}
