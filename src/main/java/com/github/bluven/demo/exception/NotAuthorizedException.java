package com.github.bluven.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by bluven on 4/5/18
 */
@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class NotAuthorizedException extends BaseException {

    public NotAuthorizedException() {
        super("用户没有登录！");
    }

    public NotAuthorizedException(String msg) {
        super(msg);
    }
}
