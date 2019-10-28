package com.sda.dto;

import org.springframework.stereotype.Service;

@Service
public class DepartmentDTO {

    private String name;

    //private Manager manager;

    //private List<Employee> employeeList;

    /*public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;*/
    //}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
