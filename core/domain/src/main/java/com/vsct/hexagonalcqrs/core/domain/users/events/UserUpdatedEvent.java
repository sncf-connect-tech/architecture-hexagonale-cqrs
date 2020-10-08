package com.vsct.hexagonalcqrs.core.domain.users.events;

import com.vsct.hexagonalcqrs.core.domain.users.entities.User;

import java.io.Serializable;

public class UserUpdatedEvent implements Serializable {

    private final User user;

    public UserUpdatedEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
