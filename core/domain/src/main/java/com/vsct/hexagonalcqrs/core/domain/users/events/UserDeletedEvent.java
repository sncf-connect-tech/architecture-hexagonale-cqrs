package com.vsct.hexagonalcqrs.core.domain.users.events;

import java.io.Serializable;

public class UserDeletedEvent implements Serializable {

    private final String email;

    public UserDeletedEvent(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
