package com.example.demo.exception;

public class BudgetRequestException extends RuntimeException {

    public BudgetRequestException(String message) {
        super(message);
    }
}
