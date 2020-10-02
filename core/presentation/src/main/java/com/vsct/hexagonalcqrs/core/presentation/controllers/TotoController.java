package com.vsct.hexagonalcqrs.core.presentation.controllers;

import com.vsct.hexagonalcqrs.core.application.TotoUseCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/toto")
public class TotoController {

    private final TotoUseCases totoUseCases;

    @Autowired
    public TotoController(TotoUseCases totoUseCases) {
        this.totoUseCases = totoUseCases;
    }

    @GetMapping
    public ResponseEntity<String> getToto() {
        String toto = totoUseCases.getToto();
        return ResponseEntity.ok(toto);
    }
}
