package com.github.bluven.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by bluven on 4/5/18
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
public class OperationForbiddenException extends BaseException {

    public OperationForbiddenException() {
        super("没有执行权限！");
    }

    public OperationForbiddenException(String msg) {
        super(msg);
    }
}
