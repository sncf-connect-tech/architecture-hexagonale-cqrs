package com.vsct.hexagonalcqrs.core.presentation.io;

import com.vsct.hexagonalcqrs.core.domain.users.queries.views.UserView;

import java.io.Serializable;
import java.time.LocalDateTime;

public class UserOutput implements Serializable {

    private String email;
    private String name;
    private LocalDateTime subscriptionDate;

    public UserOutput() {
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

    public UserOutput(UserView userView) {
        this.email = userView.getEmail();
        this.name = userView.getName();
        this.subscriptionDate = userView.getSubscriptionDate();
    }
}
