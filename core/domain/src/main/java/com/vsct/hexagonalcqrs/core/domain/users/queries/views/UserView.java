package com.vsct.hexagonalcqrs.core.domain.users.queries.views;

import java.time.LocalDate;

public class UserView {

    private final String email;
    private final String name;
    private final LocalDate subscriptionDate;

    public UserView(String email, String name, LocalDate subscriptionDate) {
        this.email = email;
        this.name = name;
        this.subscriptionDate = subscriptionDate;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public LocalDate getSubscriptionDate() {
        return subscriptionDate;
    }
}
