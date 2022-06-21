package com.example.carmark.exception;

import java.time.ZonedDateTime;

public class ApiException {

    private final String message;
    private final Throwable cause;
    private final int status;
    private final ZonedDateTime timestamp;


    public ApiException(String message, Throwable cause, int status, ZonedDateTime timestamp) {
        this.message = message;
        this.cause = cause;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getCause() {
        return cause;
    }

    public int getStatus() {
        return status;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }
}
