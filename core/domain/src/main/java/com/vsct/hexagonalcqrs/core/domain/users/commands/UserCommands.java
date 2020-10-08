package com.vsct.hexagonalcqrs.core.domain.users.commands;

import com.vsct.hexagonalcqrs.core.domain.users.entities.User;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCommands {

    private final CommandGateway commandGateway;

    @Autowired
    public UserCommands(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    public String createUser(User user) {
        return commandGateway.sendAndWait(new CreateUserCommand(user));
    }

    public void updateUser(User user) {
        commandGateway.sendAndWait(new UpdateUserCommand(user.getEmail(), user));
    }

    public void deleteUser(String email) {
        commandGateway.sendAndWait(new DeleteUserCommand(email));
    }
}
