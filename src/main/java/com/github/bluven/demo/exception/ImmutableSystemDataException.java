package com.github.bluven.demo.exception;

/**
 * 类 <code>ImmutableSystemDataException</code>
 *
 * @author bluven
 * @since 4/25/18
 */


public class ImmutableSystemDataException extends OperationForbiddenException {
    public ImmutableSystemDataException() {
        super("系统数据，不可修改");
    }
}
