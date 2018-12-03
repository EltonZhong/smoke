package com.ez.tools.validator.core.detail;

import com.ez.tools.validator.annotations.VString;

public class TestDto {
    String testMethod1 = "";
    String testMethod2 = "notEmpty";

    @VString("")
    public String testMethod1() {
        return testMethod1;
    }

    public String testMethod2(String test) {
        return testMethod1;
    }

    @VString(notEmpty = true)
    public String testMethod2() {
        return testMethod2;
    }
}
