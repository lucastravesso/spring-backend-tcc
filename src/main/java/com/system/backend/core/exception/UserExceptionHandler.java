package com.system.backend.core.exception;

public class UserExceptionHandler extends AbstractDomainException{

    public UserExceptionHandler(String code, String message) {
        super(code, message);
    }

    public static UserExceptionHandler UserException001_UserNotFound(){
        return new UserExceptionHandler("UE-001", "User not found in database.");
    }

    public static UserExceptionHandler UserException002_FailToCreateUser(){
        return new UserExceptionHandler("UE-002", "Error to create a new user.");
    }
}
