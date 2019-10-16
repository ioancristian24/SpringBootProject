package com.sda.implementationDAO;

import com.sda.entities.Employee;

public interface EmployeeDAO {

    void addEmployee(Employee employee);
    Employee displayEmployeeById(Integer id);
    Employee updateEmployeeById(Integer id, String position);
    void deleteEmployeeById(Integer id);

}
