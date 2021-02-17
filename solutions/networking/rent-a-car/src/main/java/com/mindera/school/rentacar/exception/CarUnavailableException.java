package com.mindera.school.rentacar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CarAlreadyExistsException extends RuntimeException {

    public CarAlreadyExistsException() {
        super("Car already exists");
    }
}
