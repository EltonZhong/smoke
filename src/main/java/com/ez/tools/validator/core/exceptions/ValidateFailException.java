package com.ez.tools.validator.core.exceptions;

/**
 * Not using IllegalStateException.
 * TODO: use this exception instead
 */
public class ValidateFailException extends RuntimeException {
    public ValidateFailException(String s) {
        super(s);
    }
}
