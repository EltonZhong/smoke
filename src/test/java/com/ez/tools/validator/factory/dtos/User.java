package com.ez.tools.validator.factory.dtos;

import com.ez.tools.validator.annotations.VInt;
import com.ez.tools.validator.annotations.VNotNull;
import com.ez.tools.validator.annotations.VString;

public class User {
    @VNotNull
    public User notNullField = null;

    @VNotNull
    @VString({"name1", "name2"})
    public String name = null;

    @VInt({1, 2})
    public int age = 0;

    @VString(shouldBe = {"1", "2", "3"})
    public String fieldShoudBeIn123 = null;

    @VString(shouldNotBe = {"1", "2", "3", "4"})
    public String fieldShouNotBe1234 = null;

    @VString({"1", "2"})
    public String valueShouldBe12 = null;

    @VString(shouldContain = {"abc", "123"})
    public String shouldContain_abc_And_123;

    @VString(shouldNotContain = {"abc", "123"})
    public String shouldNotContain_abc_And_123;

    @VNotNull
    public User getNotNullField() {
        return notNullField;
    }

    @VString(shouldNotContain = {"abc", "123"})
    public String getShouldNotContain_abc_And_123() {
        return shouldNotContain_abc_And_123;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @VString(shouldBe = {"1", "2", "3"})
    public String getFieldShoudBeIn123() {
        return fieldShoudBeIn123;
    }

    @VString(shouldNotBe = {"1", "2", "3", "4"})
    public String getFieldShouNotBe1234() {
        return fieldShouNotBe1234;
    }

    @VString({"1", "2"})
    public String getValueShouldBe12() {
        return valueShouldBe12;
    }

    @VString(shouldContain = {"abc", "123"})
    public String getShouldContain_abc_And_123() {
        return shouldContain_abc_And_123;
    }
}
