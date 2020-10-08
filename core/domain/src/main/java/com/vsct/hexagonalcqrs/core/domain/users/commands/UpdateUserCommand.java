package com.vsct.hexagonalcqrs.core.domain.users.commands;

import com.vsct.hexagonalcqrs.core.domain.users.entities.User;
import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class UpdateUserCommand {

    @TargetAggregateIdentifier
    private final String email;
    private final User user;

    public UpdateUserCommand(String email, User user) {
        this.email = email;
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
