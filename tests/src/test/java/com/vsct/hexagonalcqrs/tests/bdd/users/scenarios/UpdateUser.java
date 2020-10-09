package com.vsct.hexagonalcqrs.tests.bdd.users.scenarios;

import com.vsct.hexagonalcqrs.core.presentation.io.UserInput;
import com.vsct.hexagonalcqrs.tests.bdd.common.TestContext;
import com.vsct.hexagonalcqrs.tests.bdd.users.UserClient;
import com.vsct.hexagonalcqrs.tests.bdd.users.builders.UserBuilder;
import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NO_CONTENT;

public class UpdateUser implements En {
    @Autowired
    TestContext testContext;
    @Autowired
    UserClient userClient;
    @Autowired
    UserBuilder userBuilder;

    public UpdateUser() {
        When("I update this user", () -> {
            UserInput userInput = userBuilder.withName("tata").buildUserInput();
            ResponseEntity<String> responseEntity = userClient.updateUser(userInput);
            testContext.setResponseEntity(responseEntity);
        });

        When("I try to update this with the same name", () -> {
            UserInput userInput = userBuilder.buildUserInput();
            ResponseEntity<String> responseEntity = userClient.updateUser(userInput);
            testContext.setResponseEntity(responseEntity);
        });

        Then("the user is successfully updated", () -> {
            assertEquals(NO_CONTENT, testContext.getResponseStatusCode());
        });

        Then("the update is rejected with a bad request error", () -> {
            assertEquals(BAD_REQUEST, testContext.getResponseStatusCode());
        });
    }
}
