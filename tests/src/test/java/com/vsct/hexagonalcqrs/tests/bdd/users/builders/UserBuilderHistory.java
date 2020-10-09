package com.vsct.hexagonalcqrs.tests.bdd.users.builders;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserBuilderHistory {

    private List<UserBuilder> userBuilders;

    public UserBuilderHistory() {
        reset();
    }

    public void reset() {
        userBuilders = new ArrayList<>();
    }
}
