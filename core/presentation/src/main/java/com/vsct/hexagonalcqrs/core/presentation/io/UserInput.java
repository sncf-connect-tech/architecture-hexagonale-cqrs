package com.vsct.hexagonalcqrs.core.presentation.io;

import com.vsct.hexagonalcqrs.core.domain.users.entities.User;

public class UserInput {

    private final String email;
    private final String name;

    public UserInput(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public User toDomainInstance() {
        return new User(email, name);
    }
}
