package com.vsct.hexagonalcqrs.tests.bdd.users.builders;

import com.vsct.hexagonalcqrs.core.presentation.io.UserInput;
import org.springframework.stereotype.Component;

@Component
public class UserBuilder {

    private String email;
    private String name;

    public UserBuilder() {
        reset();
    }

    public String getEmail() {
        return email;
    }

    public UserBuilder reset() {
        email = "toto@email.com";
        name = "toto";
        return this;
    }

    public UserInput buildUserInput() {
        return new UserInput(email, name);
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }
}
