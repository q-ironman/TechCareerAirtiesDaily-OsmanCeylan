package com.example.osmanceylan.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(DailyNotFoundException.class)
    public String handlingBlogNotFoundException(){return ExceptionMessages.dailyNotFoundMessage;}
}
