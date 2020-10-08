package com.vsct.hexagonalcqrs.core.domain.users.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String email) {
        super("User not found with email address: " + email);
    }
}
