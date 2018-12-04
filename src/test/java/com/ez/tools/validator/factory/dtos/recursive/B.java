package com.ez.tools.validator.factory.dtos.recursive;

import com.ez.tools.validator.annotations.VNotNull;
import com.ez.tools.validator.annotations.VRecursive;

public class B {

    @VNotNull
    public String notnull = null;

    @VNotNull
    public String getNotnull() {
        return notnull;
    }

    @VRecursive
    public A a = null;
}
