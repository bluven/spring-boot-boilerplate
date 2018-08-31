package com.github.bluven.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 该异常用来表示资源跟其他资源尚有关联, 删除有危险
 *
 * @author bluven
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class BeingUsedException extends BaseException {

    public BeingUsedException() {
        super("该资源正被使用中，不可删除");
    }

    public BeingUsedException(String msg) {
        super(msg);
    }
}
