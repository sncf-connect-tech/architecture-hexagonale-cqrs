package com.vsct.hexagonalcqrs.tests.bdd.users.builders;

import com.vsct.hexagonalcqrs.core.presentation.io.UserOutput;
import org.apache.commons.lang3.SerializationUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class UserBuilderHistory {

    private List<UserBuilder> userBuilders;

    public UserBuilderHistory() {
        reset();
    }

    public void reset() {
        userBuilders = new ArrayList<>();
    }

    public void addUserBuilder(UserBuilder userBuilder) {
        userBuilders.add(SerializationUtils.clone(userBuilder));
    }

    public List<UserOutput> buildUserOutputs() {
        return userBuilders.stream()
                .map((UserBuilder::buildUserOutput))
                .collect(toList());
    }
}
