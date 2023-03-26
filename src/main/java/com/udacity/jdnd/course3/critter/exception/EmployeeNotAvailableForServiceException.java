package com.udacity.jdnd.course3.critter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class EmployeeNotAvailableForServiceException extends RuntimeException {

    public EmployeeNotAvailableForServiceException(Collection<Long> ids) {
        super(String.format("Employees with id: %s are not available for service", ids));
    }
}
