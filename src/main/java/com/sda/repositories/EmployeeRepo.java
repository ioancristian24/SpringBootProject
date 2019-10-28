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

    public Employee createEmployee(Employee employee){
        System.out.println("Am ajuns in clasa EmployeeRepo");
        getEmployeeDao().addEmployee(employee);
        return employee;
    }

    public List<Employee> readAllEmployees(){
        List<Employee>employeeList = getEmployeeDao().displayAllEmployees();
        return employeeList;
    }

    public List<Employee> displayEmployeeByName(String name) {
        List<Employee> employeeList = employeeDao.displayEmployeeByName(name);
        return employeeList;
    }

    public List<Employee> displayEmployeesByNameAndPosition(String name, String position) {
        List<Employee>employeeList = employeeDao.displayEmployeesByNameAndPosition(name, position);
        return employeeList;
    }

    public boolean deleteEmployee(String name) {
        return employeeDao.deleteEmployeeByName(name);
    }

    public boolean deleteEmployeeByNameAndPosition(String name, String position) {
        return employeeDao.deleteEmployeeByNameAndPosition(name, position);
    }

    public Employee updateEmployee(String name, Employee employee) {
        return employeeDao.updateEmployee(name, employee);
    }
}
