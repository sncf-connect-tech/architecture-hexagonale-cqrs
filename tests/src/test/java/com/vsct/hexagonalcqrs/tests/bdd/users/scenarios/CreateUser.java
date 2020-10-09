package com.vsct.hexagonalcqrs.tests.bdd.users.scenarios;

import com.vsct.hexagonalcqrs.core.presentation.io.UserInput;
import com.vsct.hexagonalcqrs.tests.bdd.common.TestContext;
import com.vsct.hexagonalcqrs.tests.bdd.users.UserClient;
import com.vsct.hexagonalcqrs.tests.bdd.users.builders.UserBuilder;
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

    public CreateUser() {
        Given("a user to create", () -> {
            userBuilder.reset();
        });

        Given("an existing user", () -> {
            UserInput userInput = userBuilder.reset().buildUserInput();
            ResponseEntity<String> responseEntity = userClient.createUser(userInput);
            assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        });

        Given("{int} existing users", (Integer usersCount) -> {
            for (int index = 0; index < usersCount; index++) {
                String name = "toto-" + index;
                UserInput userInput = userBuilder.reset()
                        .withEmail(name + "@email.com")
                        .withName(name)
                        .buildUserInput();
                ResponseEntity<String> responseEntity = userClient.createUser(userInput);
                assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
            }
        });

        When("I create this user", () -> {
            UserInput userInput = userBuilder.buildUserInput();
            ResponseEntity<String> responseEntity = userClient.createUser(userInput);
            testContext.setResponseEntity(responseEntity);
        });

        Then("the user is successfully created", () -> {
            assertEquals(HttpStatus.CREATED, testContext.getResponseStatusCode());
        });
    }
}
