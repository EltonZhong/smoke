package com.ez.tools.validator.util;

/**
 * Common regexps.
 */
public class Regexps {
    public static final String EMAIL = "\\w+@\\w+\\.[a-z]+(\\.[a-z]+)?";
    public static final String DECIMALS = "\\-?[1-9]\\d+(\\.\\d+)?";
    public static final String URL = "(https?://(w{3}\\.)?)?\\w+\\.\\w+(\\.[a-zA-Z]+)*(:\\d{1,5})?(/\\w*)*(\\??(.+=.*)?(&.+=.*)?)?";
    public static final String IP_ADDRESS = "[1-9](\\d{1,2})?\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))\\.(0|([1-9](\\d{1,2})?))";
}
