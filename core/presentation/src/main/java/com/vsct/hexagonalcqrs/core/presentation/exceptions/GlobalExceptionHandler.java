package com.vsct.hexagonalcqrs.core.presentation.exceptions;

import com.vsct.hexagonalcqrs.core.domain.users.exceptions.UserAlreadyExistsException;
import com.vsct.hexagonalcqrs.core.domain.users.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

/**
 * Centralisation de la gestion des exceptions (bien pratique)
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity handleConflict(Exception exception) {
        return ResponseEntity.status(CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity handleBadRequest(Exception exception) {
        return ResponseEntity.status(BAD_REQUEST).body(exception.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity handleNotFound(Exception exception) {
        return ResponseEntity.status(NOT_FOUND).body(exception.getMessage());
    }
}
