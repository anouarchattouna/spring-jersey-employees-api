package org.anotherdev.service;

import org.anotherdev.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeService {

    @Autowired
    @Qualifier("employeeRepository")
    private EmployeeRepository employeeRepository;

    public Employee findByFirstNameAndLastName(String firstName, String lastName) {
        return employeeRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
