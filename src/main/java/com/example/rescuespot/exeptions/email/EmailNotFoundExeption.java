package com.example.rescuespot.exeptions.email;

public class EmailNotFoundExeption extends RuntimeException {
    public EmailNotFoundExeption(String message) {
        super(message);
    }
}
