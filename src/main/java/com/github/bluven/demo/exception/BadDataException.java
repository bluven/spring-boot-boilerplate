package com.github.bluven.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by bluven on 4/7/18
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadDataException extends BaseException {

    public BadDataException() {
        super("参数错误！");
    }

    public BadDataException(String msg) {
        super(msg);
    }
}
