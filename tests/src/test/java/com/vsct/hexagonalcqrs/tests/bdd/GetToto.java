package com.vsct.hexagonalcqrs.tests.bdd;

import io.cucumber.java8.En;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

public class GetToto implements En {

    @Autowired
    RestTemplate restTemplate;

    private ResponseEntity responseEntity;

    public GetToto() {
        Given("^an existing toto$", () -> {
            //Howdy
        });

        When("^I get toto$", () -> {
            responseEntity = restTemplate.getForEntity("/toto", String.class);
        });

        Then("^toto is successfully retrieved$", () -> {
            assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
            assertEquals("toto", responseEntity.getBody());
        });
    }
}
