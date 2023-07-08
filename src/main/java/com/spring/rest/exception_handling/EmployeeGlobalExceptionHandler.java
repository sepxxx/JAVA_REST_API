package com.spring.rest.exception_handling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class EmployeeGlobalExceptionHandler {
    @ExceptionHandler
    ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException noSuchEmployeeException) {
        EmployeeIncorrectData employeeIncorrectData = new EmployeeIncorrectData();
        employeeIncorrectData.setInfo(noSuchEmployeeException.getMessage());
        return new ResponseEntity<EmployeeIncorrectData>(employeeIncorrectData, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    ResponseEntity<EmployeeIncorrectData> handleException(Exception exception) {
        EmployeeIncorrectData employeeIncorrectData = new EmployeeIncorrectData();
        employeeIncorrectData.setInfo(exception.getMessage());
        return new ResponseEntity<EmployeeIncorrectData>(employeeIncorrectData, HttpStatus.BAD_REQUEST);
    }

}
