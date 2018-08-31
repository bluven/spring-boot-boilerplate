package com.github.bluven.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by bluven on 4/5/18
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class NotUniqueException extends BaseException {

    public NotUniqueException(String msg) {
        super(msg);
    }
}
