package com.spring.rest.dao;


import com.spring.rest.entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeDAO {
  List<Employee> getAllEmployees();
  void saveEmployee(Employee employee);

  Employee getEmployee(int id);

    void deleteEmployee(int id);
}
