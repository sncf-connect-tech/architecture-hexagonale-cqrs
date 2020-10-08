package com.vsct.hexagonalcqrs.core.domain.users.exceptions;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String email) {
        super("User already exists with email address: " + email);
    }
}
