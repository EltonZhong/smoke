package com.ez.tools.validator.factory.dtos;

import com.ez.tools.validator.annotations.VInt;
import com.ez.tools.validator.annotations.VNotNull;
import com.ez.tools.validator.annotations.VString;

public class MixedDto {
    public String stringForMethodTest = "1";

    @VString(notEmpty = true)
    public String stringField;

    @VNotNull
    public User user;

    @VInt(notZero = true)
    public int anInt;

    @VString("1")
    public String get() {
        return stringForMethodTest;
    }
}
