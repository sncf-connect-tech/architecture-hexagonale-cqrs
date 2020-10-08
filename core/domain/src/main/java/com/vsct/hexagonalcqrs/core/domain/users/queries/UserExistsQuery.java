package com.vsct.hexagonalcqrs.core.domain.users.queries;

public class UserExistsQuery {

    private final String email;

    public UserExistsQuery(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
