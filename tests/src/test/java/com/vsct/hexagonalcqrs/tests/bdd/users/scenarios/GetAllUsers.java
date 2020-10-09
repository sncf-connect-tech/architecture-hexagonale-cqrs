package com.vsct.hexagonalcqrs.tests.bdd.users.scenarios;

import com.vsct.hexagonalcqrs.core.presentation.io.UserOutput;
import com.vsct.hexagonalcqrs.tests.bdd.common.TestContext;
import com.vsct.hexagonalcqrs.tests.bdd.users.UserClient;
import com.vsct.hexagonalcqrs.tests.bdd.users.builders.UserBuilder;
import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class GetAllUsers implements En {
    @Autowired
    TestContext testContext;
    @Autowired
    UserClient userClient;
    @Autowired
    UserBuilder userBuilder;

    public GetAllUsers() {
        When("I get all the users", () -> {
            ResponseEntity<UserOutput[]> responseEntity = userClient.getAllUsers();
            testContext.setResponseEntity(responseEntity);
        });

        Then("all the existing users are successfully retrieved", () -> {
            assertEquals(HttpStatus.OK, testContext.getResponseStatusCode());
        });
    }
}
