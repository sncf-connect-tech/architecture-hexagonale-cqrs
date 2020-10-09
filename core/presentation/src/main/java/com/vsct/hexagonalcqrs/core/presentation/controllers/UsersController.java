package com.vsct.hexagonalcqrs.core.presentation.controllers;

import com.vsct.hexagonalcqrs.core.application.users.UserUseCases;
import com.vsct.hexagonalcqrs.core.domain.users.entities.User;
import com.vsct.hexagonalcqrs.core.domain.users.queries.views.UserView;
import com.vsct.hexagonalcqrs.core.presentation.io.UserInput;
import com.vsct.hexagonalcqrs.core.presentation.io.UserOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/users")
public class UsersController {

    private final UserUseCases userUseCases;

    @Autowired
    public UsersController(UserUseCases userUseCases) {
        this.userUseCases = userUseCases;
    }

    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody UserInput userInput) {
        User user = userInput.toDomainInstance();
        String email = userUseCases.createUser(user);
        return ResponseEntity.created(URI.create("/users/" + email)).build();
    }

    @PutMapping
    public ResponseEntity<String> updateUser(@Valid @RequestBody UserInput userInput) {
        User user = userInput.toDomainInstance();
        userUseCases.updateUser(user);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{email:.*}")
    public ResponseEntity<String> deleteUser(@PathVariable("email") String email) {
        userUseCases.deleteUser(email);
        return ResponseEntity.ok("User " + email + " deleted");
    }

    @GetMapping(value = "/{email:.+}")
    public ResponseEntity<UserOutput> getUser(@PathVariable("email") String email) {
        UserView userView = userUseCases.findUser(email);
        UserOutput userOutput = new UserOutput(userView);
        return ResponseEntity.ok(userOutput);
    }

    @GetMapping
    public ResponseEntity<List<UserOutput>> getAllUsers() {
        List<UserOutput> userOutputs = userUseCases.findAllUsers()
                .stream()
                .map(UserOutput::new)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userOutputs);
    }
}
