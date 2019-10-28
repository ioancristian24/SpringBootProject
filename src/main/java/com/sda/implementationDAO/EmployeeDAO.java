package com.sda.implementationDAO;

import com.sda.entities.Employee;

public interface EmployeeDAO {

    Employee addEmployee(Employee employee);
    Employee displayEmployeeById(Integer id);
    Employee updateEmployeeById(Integer id, String position);
    void deleteEmployeeById(Integer id);

}
