package com.epam.task2.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorDetails {
    private HttpStatus status;
    private String message;

    public ErrorDetails(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}
