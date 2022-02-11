package ua.uni.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(value = StudentNotFountException.class)
    public ResponseEntity processStudentException (StudentNotFountException studentNotFountException) {
        return new ResponseEntity(studentNotFountException.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
