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

    public static UserExceptionHandler UserException003_FailToConvertUser(){
        return new UserExceptionHandler("UE-003", "Error to converte user.");
    }

    public static UserExceptionHandler UserException004_EmptyBody(){
        return new UserExceptionHandler("UE-004", "Can't create a user without body.");
    }
}
