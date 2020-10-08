package com.vsct.hexagonalcqrs.core.domain.users.exceptions;

public class UserNameHasNotChangedException extends RuntimeException {

    public UserNameHasNotChangedException(String name) {
        super("User name is not different: " + name);
    }
}
