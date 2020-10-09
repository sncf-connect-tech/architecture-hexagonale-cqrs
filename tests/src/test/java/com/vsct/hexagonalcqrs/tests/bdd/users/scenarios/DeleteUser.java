package com.vsct.hexagonalcqrs.tests.bdd.users.scenarios;

import com.vsct.hexagonalcqrs.tests.bdd.common.TestContext;
import com.vsct.hexagonalcqrs.tests.bdd.users.UserClient;
import com.vsct.hexagonalcqrs.tests.bdd.users.builders.UserBuilder;
import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class DeleteUser implements En {
    @Autowired
    TestContext testContext;
    @Autowired
    UserClient userClient;
    @Autowired
    UserBuilder userBuilder;

    public DeleteUser() {
        When("I delete this user", () -> {
            ResponseEntity<String> responseEntity = userClient.updateUser(userBuilder.getEmail());
            testContext.setResponseEntity(responseEntity);
        });

        Then("the user is successfully deleted", () -> {
            assertEquals(HttpStatus.OK, testContext.getResponseStatusCode());
        });
    }
}
