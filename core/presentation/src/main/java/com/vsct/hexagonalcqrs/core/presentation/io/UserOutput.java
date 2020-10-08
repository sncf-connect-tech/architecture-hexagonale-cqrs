package com.vsct.hexagonalcqrs.core.presentation.io;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vsct.hexagonalcqrs.core.domain.users.queries.views.UserView;

import java.time.LocalDateTime;

public class UserOutput {

    private final String email;
    private final String name;
    @JsonProperty("subscription_date")
    private final LocalDateTime subscriptionDate;

    public UserOutput(UserView userView) {
        this.email = userView.getEmail();
        this.name = userView.getName();
        this.subscriptionDate = userView.getSubscriptionDate();
    }
}
