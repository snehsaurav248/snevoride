package com.snevoride.snevoride.exception;

public class ErrorResponse {

    private int status;
    private String message;
    private String description;

    public ErrorResponse(int status, String message, String description) {
        this.status = status;
        this.message = message;
        this.description = description;
    }

    // getters & setters
}
