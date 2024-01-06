package com.vanderlelie.api.backend.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    // Additional constructors or methods can be added as needed
}
