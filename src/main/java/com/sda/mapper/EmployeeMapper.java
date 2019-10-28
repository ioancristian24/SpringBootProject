package com.sda.mapper;

import com.sda.dto.EmployeeDTO;
import com.sda.entities.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeDTO convertEmployeeToEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(employee.getName());
        employeeDTO.setPosition(employee.getPosition());
        employeeDTO.setAge(employee.getAge());
        /*employeeDTO.setDepartment(employee.getDepartment());*/
        return employeeDTO;
    }

    public Employee convertEmployeeDTOToEmployee(EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setAge(employeeDTO.getAge());
        employee.setPosition(employeeDTO.getPosition());
        /*employee.setDepartment(employeeDTO.getDepartment());*/
        return employee;
    }
}
