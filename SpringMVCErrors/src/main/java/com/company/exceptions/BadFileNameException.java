package com.company.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Bad bad bad")
public class BadFileNameException extends Exception {
    public BadFileNameException() {
    }

    public BadFileNameException(String s) {
        super(s);
    }
}
