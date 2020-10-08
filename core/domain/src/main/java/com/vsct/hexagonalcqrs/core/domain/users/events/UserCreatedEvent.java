package com.vsct.hexagonalcqrs.core.domain.users.events;

import com.vsct.hexagonalcqrs.core.domain.users.entities.User;

import java.io.Serializable;

public class UserCreatedEvent implements Serializable {

    private final User user;

    public UserCreatedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
