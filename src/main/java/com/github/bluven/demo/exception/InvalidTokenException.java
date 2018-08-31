package com.github.bluven.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Created by bluven on 3/21/18
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidTokenException extends BaseException {

    public InvalidTokenException() {
       super("身份信息已失效");
    }

    public InvalidTokenException(String msg) {
       super(msg);
    }


    public InvalidTokenException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
