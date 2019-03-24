package com.klaus.demospringes.ex;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Klaus Mikaelson
 * @class demo-spring-test-com.klaus.demospringes.ex GlobalRestExceptionHandler
 * @description:
 * @date 2019/3/25 02:08
 */
@ControllerAdvice
@Slf4j
public class GlobalRestExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ResponseEntity defaultExceptionHandler(HttpServletRequest request, final Exception e) {
        log.info("request is {}" ,  request);
        ApiErrorResponse response =ApiErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .error_code(e.getMessage())
                .message(e.getLocalizedMessage())
                .path(request.getRequestURI())
                .build()   ;
        return new ResponseEntity<>(response, response.getStatus());
    }

/*
    @ExceptionHandler({MethodArgumentTypeMismatchException.class})
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        ApiErrorResponse response =ApiErrorResponse.builder()
                .status(status)
                .error_code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(ex.getLocalizedMessage())
        .build()   ;

        return new ResponseEntity<>(response, response.getStatus());
    }


    @ExceptionHandler({HttpMessageNotReadableException.class})
    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request ";
        ApiErrorResponse response =ApiErrorResponse.builder()
                .status(status)
                .error_code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(ex.getLocalizedMessage())
                .detail(error + ex.getMessage())
                .build()   ;
        return new ResponseEntity<>(response, response.getStatus());
    }
*/



    @ExceptionHandler(ArithmeticException.class)
    protected ResponseEntity<Object> handleCustomAPIException(ArithmeticException ex) {
        ApiErrorResponse response =new ApiErrorResponse.ApiErrorResponseBuilder()
                .status(HttpStatus.BAD_REQUEST)
                .error_code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(ex.getLocalizedMessage())
                .detail(ex.getMessage())
                .build();
        return new ResponseEntity<>(response, response.getStatus());
    }
}
