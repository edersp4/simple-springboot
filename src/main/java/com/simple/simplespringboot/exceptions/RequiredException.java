package com.simple.simplespringboot.exceptions;

public class RequiredException extends RuntimeException {
    public RequiredException(String message) {
        super(message);
    }
}
