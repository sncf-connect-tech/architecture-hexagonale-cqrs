package com.vsct.hexagonalcqrs.core.presentation.io;

import com.vsct.hexagonalcqrs.core.domain.users.entities.User;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class UserInput implements Serializable {

    @NotEmpty
    private String email;
    @NotEmpty
    private String name;

    public UserInput() {
    }

    public UserInput(String email, String name) {
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public User toDomainInstance() {
        return new User(email, name);
    }
}
