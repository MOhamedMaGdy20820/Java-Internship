package com.app.LMS.exceptions;

public class CustomException extends RuntimeException {
    public CustomException(String exMessage, Exception exception) {
        super(exMessage, exception);
    }

    public CustomException(String exMessage) {
        super(exMessage);
    }

    public CustomException() {
        super();
    }
}