package com.example.rescuespot.controllerAdvice;


import com.example.rescuespot.exeptions.email.EmailNotFoundExeption;
import com.example.rescuespot.exeptions.password.PasswordIsRequiredExeption;
import com.example.rescuespot.exeptions.user.UserNotFoundExeption;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmailNotFoundExeption.class)
    public ResponseEntity<String>  handleEmailNotFoundExeption(EmailNotFoundExeption e){
        return  ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }

    @ExceptionHandler(UserNotFoundExeption.class)
    public ResponseEntity<String>  handleUserNotFoundExeption(UserNotFoundExeption e){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(PasswordIsRequiredExeption.class)
    public ResponseEntity<String> handlePasswordIsRequiredExeption(PasswordIsRequiredExeption e){
        return  ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
    }
}
