package com.system.backend.core.exception;

public class SecurityExceptionHandler extends AbstractDomainException{

    public SecurityExceptionHandler(String code, String message) {
        super(code, message);
    }

    public static SecurityExceptionHandler SecurityException001_UserNotFound(){
        return new SecurityExceptionHandler("SE-001", "User not found in database or missing some field.");
    }

}
