package com.spring.rest.controller;


import com.spring.rest.entity.Employee;
import com.spring.rest.exception_handling.EmployeeIncorrectData;
import com.spring.rest.exception_handling.NoSuchEmployeeException;
import com.spring.rest.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) throws Exception {
        Employee employee = employeeService.getEmployee(id);
        if(employee==null) {
            throw new NoSuchEmployeeException("There is no employee with id " +id+ " in db");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) throws NoSuchEmployeeException {
        Employee employee = employeeService.getEmployee(id);
        if(employee==null) {
            throw new NoSuchEmployeeException("There is no employee with id " +id+ "in db");
        }
        employeeService.deleteEmployee(id);
        return "Deleted id "+ id+ " from db";
    }
}
