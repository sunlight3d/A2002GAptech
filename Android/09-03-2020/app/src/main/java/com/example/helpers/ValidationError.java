package com.example.helpers;

public class ValidationError {
    public static final ValidationError EMAIL_ERROR = new ValidationError(
            100,
            "Email is not in correct format");
    public static final ValidationError PASSWORD_ERROR = new ValidationError(
            101,
            "Password must be at least 2 characters");
    private Integer errorCode;
    private String errorDetail;//EX: password must have at least 2 characters, ...
    public ValidationError(Integer errorCode, String errorDetail) {
        this.errorCode = errorCode;
        this.errorDetail = errorDetail;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorDetail() {
        return errorDetail;
    }
}
