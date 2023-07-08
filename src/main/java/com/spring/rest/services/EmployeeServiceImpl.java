package com.spring.rest.services;

import com.spring.rest.dao.EmployeeDAO;
import com.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }


    @Transactional
    public  void saveEmployee(Employee employee) {
        employeeDAO.saveEmployee(employee);
    }


    @Transactional
    public Employee getEmployee(int id) {
        return employeeDAO.getEmployee(id);
    }


    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }
}
