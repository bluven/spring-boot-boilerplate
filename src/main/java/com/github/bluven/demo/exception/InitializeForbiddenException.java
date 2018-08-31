package com.github.bluven.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by bluven on 3/30/18
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class InitializeForbiddenException extends BaseException {
    public InitializeForbiddenException() {
        super("操作失败， 平台管理员已经初始化");
    }
}
