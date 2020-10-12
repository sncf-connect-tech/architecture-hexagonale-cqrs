package com.vsct.hexagonalcqrs.tests.bdd.users.scenarios;

import com.vsct.hexagonalcqrs.core.presentation.io.UserInput;
import com.vsct.hexagonalcqrs.tests.bdd.common.TestContext;
import com.vsct.hexagonalcqrs.tests.bdd.users.UserClient;
import com.vsct.hexagonalcqrs.tests.bdd.users.builders.UserBuilder;
import com.vsct.hexagonalcqrs.tests.bdd.users.builders.UserBuilderHistory;
import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class CreateUser implements En {
    @Autowired
    TestContext testContext;
    @Autowired
    UserClient userClient;
    @Autowired
    UserBuilder userBuilder;
    @Autowired
    UserBuilderHistory userBuilderHistory;

    public CreateUser() {
        Given("a user to create", () -> {
            userBuilder.reset();
        });

        Given("an existing user", () -> {
            userBuilder.reset();
            createUser();
            assertEquals(HttpStatus.CREATED, testContext.getResponseStatusCode());
        });

        Given("{int} existing users", (Integer usersCount) -> {
            for (int index = 0; index < usersCount; index++) {
                String name = "toto-" + index;
                UserInput userInput = userBuilder.reset()
                        .withEmail(name + "@email.com")
                        .withName(name)
                        .buildUserInput();
                createUser();
                assertEquals(HttpStatus.CREATED, testContext.getResponseStatusCode());
            }
        });

        When("I create this user", this::createUser);

        When("I try to create a user with the same email address", this::createUser);

        Then("the user is successfully created", () -> {
            assertEquals(HttpStatus.CREATED, testContext.getResponseStatusCode());
        });

        Then("the user creation is rejected with a conflict error", () -> {
            assertEquals(HttpStatus.CONFLICT, testContext.getResponseStatusCode());
        });
    }

    private void createUser() {
        UserInput userInput = userBuilder.buildUserInput();
        ResponseEntity<String> responseEntity = userClient.createUser(userInput);
        testContext.setResponseEntity(responseEntity);
        userBuilderHistory.addUserBuilder(userBuilder);
    }
}
