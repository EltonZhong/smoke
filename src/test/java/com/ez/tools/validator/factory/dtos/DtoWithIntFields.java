package com.ez.tools.validator.factory.dtos;

import com.ez.tools.validator.annotations.VInt;
import com.ez.tools.validator.annotations.VNotNull;
import com.ez.tools.validator.annotations.VString;

public class DtoWithIntFields {
    @VNotNull
    @VString({"name1", "name2"})
    public String getName() {
        return name;
    }

    @VInt({1, 2})
    public int getAge() {
        return age;
    }

    @VInt(shouldBe = {1, 2, 3})
    public int getFieldShoudBeIn123() {
        return fieldShoudBeIn123;
    }

    @VInt(shouldNotBe = {1, 2, 3, 4})
    public Integer getFieldShouNotBe1234() {
        return fieldShouNotBe1234;
    }

    @VInt({1, 2})
    public int getValueShouldBe12() {
        return valueShouldBe12;
    }

    @VInt(greaterThan = {1, -2})
    public int getShouldBeGreaterThan1AndNagative2() {
        return shouldBeGreaterThan1AndNagative2;
    }

    @VInt(lessThan = {-100, 122})
    public Integer getShouldBeLessThan122AndNagative100() {
        return shouldBeLessThan122AndNagative100;
    }

    @VNotNull
    @VString({"name1", "name2"})
    public String name = null;

    @VInt({1, 2})
    public int age = 0;

    @VInt(shouldBe = {1, 2, 3})
    public int fieldShoudBeIn123 = 0;

    @VInt(shouldNotBe = {1, 2, 3, 4})
    public Integer fieldShouNotBe1234 = null;

    @VInt({1, 2})
    public int valueShouldBe12 = 0;

    @VInt(greaterThan = {1, -2})
    public int shouldBeGreaterThan1AndNagative2;

    @VInt(lessThan = {-100, 122})
    public Integer shouldBeLessThan122AndNagative100;
}
