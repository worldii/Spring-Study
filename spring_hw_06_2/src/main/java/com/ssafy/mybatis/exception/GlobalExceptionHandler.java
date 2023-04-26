package com.ssafy.mybatis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

import java.nio.file.AccessDeniedException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {CustomException.class})
    protected ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        return ErrorResponse.toResponseEntity(e.getErrorcode());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ErrorResponse> RuntimeExceptionExceptionHandler(final RuntimeException e) {
        e.printStackTrace();
        return ErrorResponse.toResponseEntity(ErrorCode.RUNTIME_EXCEPTION);
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    protected ResponseEntity<ErrorResponse> handleHttpRequestMethodNotSupportedException(final Exception e) {
        return ErrorResponse.toResponseEntity(ErrorCode.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ErrorResponse> AccessDeniedExceptionExceptionHandler(final AccessDeniedException e) {
        e.printStackTrace();
        return ErrorResponse.toResponseEntity(ErrorCode.ACCESS_DENIED_EXCEPTION);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> ExceptionExceptionHandler(final Exception e) {
        e.printStackTrace();
        return ErrorResponse.toResponseEntity(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}