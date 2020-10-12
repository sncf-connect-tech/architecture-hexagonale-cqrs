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

public class GetUser implements En {
    @Autowired
    TestContext testContext;
    @Autowired
    UserClient userClient;
    @Autowired
    UserBuilder userBuilder;

    public GetUser() {
        When("I get this user", () -> {
            ResponseEntity<UserOutput> responseEntity = userClient.getUser(userBuilder.getEmail());
            testContext.setResponseEntity(responseEntity);
        });

        Then("the user is successfully retrieved", () -> {
            assertEquals(HttpStatus.OK, testContext.getResponseStatusCode());
            UserOutput expectedUserOutput = userBuilder.buildUserOutput();
            UserOutput actualUserOutput = testContext.getResponseBody();
            assertEquals(expectedUserOutput, actualUserOutput);
        });
    }
}
