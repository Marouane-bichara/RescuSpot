package com.example.rescuespot.exeptions.password;

public class PasswordIsRequiredExeption extends RuntimeException {
    public PasswordIsRequiredExeption(String message) {
        super(message);
    }
}
