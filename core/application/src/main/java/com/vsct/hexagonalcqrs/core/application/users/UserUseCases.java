package com.vsct.hexagonalcqrs.core.application.users;

import com.vsct.hexagonalcqrs.core.domain.users.commands.UserCommands;
import com.vsct.hexagonalcqrs.core.domain.users.entities.User;
import com.vsct.hexagonalcqrs.core.domain.users.exceptions.UserAlreadyExistsException;
import com.vsct.hexagonalcqrs.core.domain.users.exceptions.UserNotFoundException;
import com.vsct.hexagonalcqrs.core.domain.users.queries.UserQueries;
import com.vsct.hexagonalcqrs.core.domain.users.queries.views.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserUseCases {

    private final UserCommands userCommands;
    private final UserQueries userQueries;

    @Autowired
    public UserUseCases(UserCommands userCommands, UserQueries userQueries) {
        this.userCommands = userCommands;
        this.userQueries = userQueries;
    }

    public String createUser(User user) {
        if (userQueries.userExists(user.getEmail())) {
            throw new UserAlreadyExistsException(user.getEmail());
        }
        return userCommands.createUser(user);
    }

    public void updateUser(User user) {
        if (!userQueries.userExists(user.getEmail())) {
            throw new UserNotFoundException(user.getEmail());
        }
        userCommands.updateUser(user);
    }

    public void deleteUser(String email) {
        if (!userQueries.userExists(email)) {
            throw new UserNotFoundException(email);
        }
        userCommands.deleteUser(email);
    }

    public UserView findUser(String email) {
        return userQueries.findUser(email)
                .orElseThrow(() -> new UserNotFoundException(email));
    }

    public List<UserView> findAllUsers() {
        return userQueries.findAllUsers();
    }
}
