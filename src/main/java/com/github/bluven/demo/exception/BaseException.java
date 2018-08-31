package com.github.bluven.demo.exception;

/**
 * Created by bluven on 3/20/18
 */
public class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}
