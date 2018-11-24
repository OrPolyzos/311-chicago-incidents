package com.uoa.di.csr.exception;

import org.springframework.security.core.AuthenticationException;

public class InvalidCredentialsException extends AuthenticationException {

    private static final String INVALID_CREDENTIALS_MESSAGE = "Invalid credentials";

    public InvalidCredentialsException() {
        super(INVALID_CREDENTIALS_MESSAGE);
    }

    public static String getInvalidCredentialsMessage() {
        return INVALID_CREDENTIALS_MESSAGE;
    }
}