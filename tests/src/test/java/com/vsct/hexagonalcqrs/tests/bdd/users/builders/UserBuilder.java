package com.vsct.hexagonalcqrs.tests.bdd.users.builders;

import com.vsct.hexagonalcqrs.core.presentation.io.UserInput;
import com.vsct.hexagonalcqrs.core.presentation.io.UserOutput;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.time.LocalDate;

@Component
public class UserBuilder implements Serializable {

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

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public UserInput buildUserInput() {
        return new UserInput(email, name);
    }

    public UserOutput buildUserOutput() {
        return new UserOutput(email, name, LocalDate.now());
    }
}
