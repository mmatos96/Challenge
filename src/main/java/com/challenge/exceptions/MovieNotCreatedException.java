package com.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class MovieNotCreatedException extends RuntimeException {
    public MovieNotCreatedException(String message) {
        super(message);
    }
}
