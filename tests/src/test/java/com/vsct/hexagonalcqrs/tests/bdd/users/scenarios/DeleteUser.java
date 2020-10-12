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
            deleteUser();
        });

        When("I try to delete a user that doesn't exist", () -> {
            userBuilder.withEmail("nope@email.com");
            deleteUser();
        });

        Then("the user is successfully deleted", () -> {
            assertEquals(HttpStatus.OK, testContext.getResponseStatusCode());
        });

        Then("the user deletion is rejected with a not found error", () -> {
            assertEquals(HttpStatus.NOT_FOUND, testContext.getResponseStatusCode());
        });
    }

    private void deleteUser() {
        ResponseEntity<String> responseEntity = userClient.updateUser(userBuilder.getEmail());
        testContext.setResponseEntity(responseEntity);
    }
}
