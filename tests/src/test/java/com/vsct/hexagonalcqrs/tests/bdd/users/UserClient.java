package com.vsct.hexagonalcqrs.tests.bdd.users;

import com.vsct.hexagonalcqrs.core.presentation.io.UserInput;
import com.vsct.hexagonalcqrs.core.presentation.io.UserOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {
    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<String> createUser(UserInput userInput) {
        return restTemplate.postForEntity("/users", userInput, String.class);
    }

    public ResponseEntity<String> updateUser(UserInput userInput) {
        return restTemplate.exchange("/users", HttpMethod.PUT, new HttpEntity<>(userInput), String.class);
    }

    public ResponseEntity<String> updateUser(String email) {
        return restTemplate.exchange("/users/{email}", HttpMethod.DELETE, null, String.class, email);
    }

    public ResponseEntity<UserOutput> getUser(String email) {
        return restTemplate.getForEntity("/users/{email}", UserOutput.class, email);
    }

    public ResponseEntity<UserOutput[]> getAllUsers() {
        return restTemplate.getForEntity("/users", UserOutput[].class);
    }
}
