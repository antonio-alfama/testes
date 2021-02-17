package com.mindera.school.rentacar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class DataMalformedException extends RuntimeException {

    public DataMalformedException(String message) {
        super(message);
    }
}
