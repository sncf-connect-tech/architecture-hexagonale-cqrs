package com.vsct.hexagonalcqrs.core.domain.users.entities;

import com.vsct.hexagonalcqrs.core.domain.users.exceptions.UserNameHasNotChangedException;

public class User {

    private final String email;
    private final String name;

    public User(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public void validateEmail() {
        // Not yet implemented
    }

    public void validateNameIsDifferent(String providedName) {
        if (providedName.equals(name)) {
            throw new UserNameHasNotChangedException(name);
        }
    }
}
