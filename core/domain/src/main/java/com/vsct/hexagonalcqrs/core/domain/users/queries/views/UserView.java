package com.vsct.hexagonalcqrs.core.domain.users.queries.views;

import java.time.LocalDateTime;

public class UserView {

    private final String email;
    private final String name;
    private final LocalDateTime subscriptionDate;

    public UserView(String email, String name, LocalDateTime subscriptionDate) {
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

    public LocalDateTime getSubscriptionDate() {
        return subscriptionDate;
    }
}
