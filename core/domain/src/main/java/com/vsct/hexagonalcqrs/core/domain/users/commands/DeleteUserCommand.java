package com.vsct.hexagonalcqrs.core.domain.users.commands;

import org.axonframework.commandhandling.TargetAggregateIdentifier;

public class DeleteUserCommand {

    @TargetAggregateIdentifier
    private final String email;

    public DeleteUserCommand(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
