package com.udacity.jdnd.course3.critter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Collection;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(long id) {
        super(String.format("Employee with id: %s is not found", id));
    }

    public EmployeeNotFoundException(Collection<Long> ids) {
        super(String.format("Employees with id: %s are not found", ids));
    }
}