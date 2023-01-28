package com.system.backend.core.exception;

public abstract class AbstractDomainException extends RuntimeException {

    private static final long serialVersion = 1L;
    private static String code = null;

    public AbstractDomainException(String code, String message){
        super(message);
        AbstractDomainException.code = code;
    }
}
