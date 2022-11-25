package com.example.osmanceylan.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandling {
    @ExceptionHandler(DailyNotFoundException.class)
    public @ResponseBody ErrorResponse handlingBlogNotFoundException(){
        return new ErrorResponse(HttpStatus.NOT_FOUND.value(), ExceptionMessages.dailyNotFoundMessage);
    }
}
