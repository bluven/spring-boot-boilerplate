package com.github.bluven.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 类 <code>AccessForbiddenException</code>
 *
 * @author bluven
 * @since 4/18/18
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class AccessForbiddenException extends BaseException {

    public AccessForbiddenException() {
        super("信息不可访问");
    }

    public AccessForbiddenException(String msg) {
        super(msg);
    }
}
