package com.vanderlelie.api.backend.exception;

public class AccessDeniedException extends RuntimeException {

    public AccessDeniedException(String message) {
        super(message);
    }

    // Additional constructors or methods can be added as needed
}
