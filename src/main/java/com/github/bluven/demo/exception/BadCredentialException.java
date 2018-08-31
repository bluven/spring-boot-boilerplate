package com.github.bluven.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by bluven on 3/20/18
 */

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadCredentialException extends BaseException {

    public BadCredentialException() {
        super("账户或密码错误！");
    }

    public BadCredentialException(int tries, int remainder) {
        super(String.format("账户或密码错误，您已尝试%d次，还能尝试%d次", tries, remainder));
    }

    public BadCredentialException(String msg) {
        super(msg);
    }
}
