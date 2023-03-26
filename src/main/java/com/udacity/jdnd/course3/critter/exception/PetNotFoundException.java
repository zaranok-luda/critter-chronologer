package com.udacity.jdnd.course3.critter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PetNotFoundException extends RuntimeException {
    public PetNotFoundException(long id) {
        super(String.format("Pet with id: %s is not found", id));
    }

    public PetNotFoundException(Collection<Long> ids) {
        super(String.format("Pets with id: %s are not found", ids));
    }
}