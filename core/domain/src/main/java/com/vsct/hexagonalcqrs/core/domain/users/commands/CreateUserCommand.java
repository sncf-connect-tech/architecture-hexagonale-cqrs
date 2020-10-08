package com.vsct.hexagonalcqrs.core.domain.users.commands;

import com.vsct.hexagonalcqrs.core.domain.users.entities.User;

public class CreateUserCommand {

    private final User user;

    public CreateUserCommand(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
