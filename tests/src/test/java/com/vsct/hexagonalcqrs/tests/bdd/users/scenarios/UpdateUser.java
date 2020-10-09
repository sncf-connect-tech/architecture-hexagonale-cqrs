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
            ResponseEntity<String> responseEntity = userClient.deleteUser(userInput);
            testContext.setResponseEntity(responseEntity);
        });

        Then("the user is successfully updated", () -> {
            assertEquals(HttpStatus.NO_CONTENT, testContext.getResponseStatusCode());
        });
    }
}
