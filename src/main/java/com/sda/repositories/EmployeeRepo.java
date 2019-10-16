package com.sda.repositories;

import com.sda.entities.Employee;
import com.sda.implementationDAO.implementation.EmployeeDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeRepo {

    private EmployeeDaoImpl employeeDao;

    public EmployeeDaoImpl getEmployeeDao() {
        return employeeDao;
    }

    @Autowired
    public void setEmployeeDao(EmployeeDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Employee> readAllEmployees(){
        List<Employee>employeeList = getEmployeeDao().displayAllEmployees();
        return employeeList;
    }
}
