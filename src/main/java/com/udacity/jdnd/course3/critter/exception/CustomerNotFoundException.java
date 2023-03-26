package com.udacity.jdnd.course3.critter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(long id) {
        super(String.format("Customer with id: %s is not found", id));
    }

    public CustomerNotFoundException(String message, long id) {
        super(String.format(message, id));
    }
}