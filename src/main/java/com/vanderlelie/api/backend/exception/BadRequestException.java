package com.vanderlelie.api.backend.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String message) {
        super(message);
    }

    // Additional constructors or methods can be added as needed
}
