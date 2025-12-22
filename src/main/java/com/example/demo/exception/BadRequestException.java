package com.example.demo.exception;

public class BadRequestException extends RuntimeException {

    public BudgetRequestException(String message) {
        super(message);
    }
}
