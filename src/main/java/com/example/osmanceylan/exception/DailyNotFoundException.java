package com.example.osmanceylan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DailyNotFoundException extends RuntimeException{
    private String message;

    public DailyNotFoundException() {}

    public DailyNotFoundException(String msg)
    {
        super(msg);
        this.message = msg;
    }
}
