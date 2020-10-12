package com.vsct.hexagonalcqrs.tests.bdd.users.scenarios;

import com.vsct.hexagonalcqrs.core.presentation.io.UserOutput;
import com.vsct.hexagonalcqrs.tests.bdd.common.TestContext;
import com.vsct.hexagonalcqrs.tests.bdd.users.UserClient;
import com.vsct.hexagonalcqrs.tests.bdd.users.builders.UserBuilderHistory;
import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetAllUsers implements En {
    @Autowired
    TestContext testContext;
    @Autowired
    UserClient userClient;
    @Autowired
    UserBuilderHistory userBuilderHistory;

    public GetAllUsers() {
        When("I get all the users", () -> {
            ResponseEntity<UserOutput[]> responseEntity = userClient.getAllUsers();
            testContext.setResponseEntity(responseEntity);
        });

        Then("all the existing users are successfully retrieved", () -> {
            assertEquals(HttpStatus.OK, testContext.getResponseStatusCode());
            List<UserOutput> expectedUserOutputs = userBuilderHistory.buildUserOutputs();
            List<UserOutput> actualUserOutputs = testContext.getResponseBodyAsList();
            assertEqualsInAnyOrder(expectedUserOutputs, actualUserOutputs);
        });
    }

    private void assertEqualsInAnyOrder(List<?> expectedElements, List<?> actualElements) {
        assertTrue(expectedElements.size() == actualElements.size() &&
                expectedElements.containsAll(actualElements) && actualElements.containsAll(expectedElements));

    }
}
