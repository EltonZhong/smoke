package com.ez.tools.validator.core.flyweight;

import com.ez.tools.validator.annotations.VInt;
import com.ez.tools.validator.annotations.VNotNull;
import com.ez.tools.validator.annotations.VString;

public class User {

    @VNotNull
    @VString({"name1", "name2"})
    public String name = null;

    @VInt({1, 2})
    public int age = 0;
}
