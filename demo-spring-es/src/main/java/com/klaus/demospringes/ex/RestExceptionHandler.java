package com.klaus.demospringes.ex;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.ex RestExceptionHandler
 * @description:
 * @date 2019/3/25 02:33
 */
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CustomNotFoundException.class)
    public ApiErrorResponse handleNotFoundException(CustomNotFoundException ex) {
        ApiErrorResponse response =ApiErrorResponse.builder()
                .status(HttpStatus.NOT_FOUND)
                .error_code("NOT_FOUND")
                .message(ex.getLocalizedMessage()).build();
        return response;
    }
}