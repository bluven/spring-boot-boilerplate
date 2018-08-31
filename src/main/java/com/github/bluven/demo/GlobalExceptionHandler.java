package com.github.bluven.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.Map;

import com.github.bluven.demo.exception.BaseException;
import com.github.bluven.demo.util.ValidationUtil;

/**
 * Created by ace on 2017/9/8.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public @ResponseBody
    ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ErrorResponse error = new ErrorResponse(ex);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public @ResponseBody
    ResponseEntity<Object> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        ErrorResponse error = new ErrorResponse("请求数据格式错误！");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public @ResponseBody
    ResponseEntity<ErrorResponse> defaultExceptionHandler(Exception ex) {
        ErrorResponse error = new ErrorResponse(ex);

        if(ex instanceof BaseException) {
            logger.debug("Business exception happened: ", ex);
        } else {
            logger.error("Internal exception happened: ", ex);
        }

        return new ResponseEntity<>(error, getHttpStatus(ex));
    }

    private HttpStatus getHttpStatus(Exception e) {
        Annotation annotation = e.getClass().getAnnotation(ResponseStatus.class);
        if (annotation == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return ((ResponseStatus) annotation).value();
    }

    private static class ErrorResponse {
        private final String message;
        private final Map<String, String> errors;
        private final Date timestamp;

        public ErrorResponse(Exception ex) {
            this.message = ex.getMessage();
            this.errors = null;
            this.timestamp = new Date();
        }

        public ErrorResponse(String message) {
            this.message = message;
            this.timestamp = new Date();
            this.errors = null;
        }

        public ErrorResponse(MethodArgumentNotValidException ex) {
            this.message = "数据错误！";
            this.errors = ValidationUtil.fromBindingErrors(ex.getBindingResult());
            this.timestamp = new Date();
        }

        public String getMessage() {
            return message;
        }

        public Date getTimestamp() {
            return timestamp;
        }

        public Map<String, String> getErrors() {
            return errors;
        }
    }
}
