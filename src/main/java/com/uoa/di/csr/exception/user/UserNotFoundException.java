package com.uoa.di.csr.exception.user;


import com.uoa.di.csr.exception.CsrNotFoundException;

public class UserNotFoundException extends CsrNotFoundException {

    private static final String USER_WAS_NOT_FOUND_MESSAGE = "User with ID: %s was not found";

    public UserNotFoundException(Long userId) {
        super(String.format(USER_WAS_NOT_FOUND_MESSAGE, userId));
    }
}
