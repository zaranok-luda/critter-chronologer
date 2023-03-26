package com.udacity.jdnd.course3.critter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidScheduleException extends RuntimeException {

    public InvalidScheduleException(List<String> errors) {
        super(errors.toString());
    }

}
