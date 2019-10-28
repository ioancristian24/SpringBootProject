package com.sda.services;

import com.sda.dto.EmployeeDTO;
import com.sda.entities.Employee;
import com.sda.mapper.EmployeeMapper;
import com.sda.repositories.EmployeeRepo;
import com.sda.validators.EmployeeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeValidator employeeValidator;

    @Autowired
    private EmployeeMapper employeeMapper;

    public EmployeeRepo getEmployeeRepo() {
        return employeeRepo;
    }

    @Autowired
    public void setEmployeeRepo(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    /*public List<EmployeeDTO> displayEmployeeDTO(){

        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        EmployeeDTO employeeDTO1 = new EmployeeDTO();
        employeeDTO1.setName("marius");
        employeeDTO1.setAge(25);
        employeeDTO1.setPosition("worker");

        EmployeeDTO employeeDTO2 = new EmployeeDTO();
        employeeDTO2.setName("vlad");
        employeeDTO2.setAge(45);
        employeeDTO2.setPosition("manager");

        EmployeeDTO employeeDTO3 = new EmployeeDTO();
        employeeDTO3.setName("igor");
        employeeDTO3.setAge(32);
        employeeDTO3.setPosition("spammer");

        employeeDTOList.add(employeeDTO1);
        employeeDTOList.add(employeeDTO2);
        employeeDTOList.add(employeeDTO3);
        return employeeDTOList;
    }*/

    public List<EmployeeDTO> displayAllEmployees(){
        List<Employee> employeeList = getEmployeeRepo().readAllEmployees();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for (Employee employee : employeeList){
            employeeDTOS.add(employeeMapper.convertEmployeeToEmployeeDTO(employee));
        }
        return employeeDTOS;
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO){
        System.out.println("Am ajuns in clasa EmployeeService");
        EmployeeDTO employeeDTO1 = null;
        if (employeeValidator.isDTOValid(employeeDTO)){
            Employee employee = employeeMapper.convertEmployeeDTOToEmployee(employeeDTO);

            Employee employee1 = getEmployeeRepo().createEmployee(employee);

            employeeDTO1 = employeeMapper.convertEmployeeToEmployeeDTO(employee1);
        }else {
            System.out.println("Valorile introduse nu indeplinesc conditiile de eligibilitate. ");
        }
        return employeeDTO1;
    }

    public List<EmployeeDTO> displayEmployeeDTOByName(String name) {
        System.out.println("Am ajuns in clasa EmployeeService");
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        if (employeeValidator.isNameValid(name)) {
            List<Employee> employeeList = employeeRepo.displayEmployeeByName(name);
            for (Employee employee : employeeList){
                employeeDTOList.add(employeeMapper.convertEmployeeToEmployeeDTO(employee));
            }
        }else {
            System.out.println("Name is not valid! ");
        }
        return employeeDTOList;
    }

    public List<EmployeeDTO> displayEmployeeDTOByNameAndPosition(String name, String position) {
        System.out.println("Am ajuns in clasa EmployeeService");
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();
        if (employeeValidator.isNameValid(name) && employeeValidator.isPositionValid(position)){
            List<Employee>employeeList = employeeRepo.displayEmployeesByNameAndPosition(name, position);
            for (Employee employee : employeeList){
                employeeDTOList.add(employeeMapper.convertEmployeeToEmployeeDTO(employee));
            }
        }else {
            System.out.println("Name or position or both is not valid! ");
        }
        return employeeDTOList;
    }

    public boolean deleteEmployeeByName(String name) {
        boolean isDeleted = false;
        if (employeeValidator.isNameValid(name)){
            isDeleted = employeeRepo.deleteEmployee(name);
        }
        if (isDeleted){
            System.out.println("Employee was deleted");
        }else{
            System.out.println("Employee was not deleted");
        }
        return isDeleted;
    }

    public boolean deleteEmployeeByNameAndPosition(String name, String position) {
        boolean isDeleted = false;
        if (employeeValidator.isNameValid(name) && employeeValidator.isPositionValid(position)){
            isDeleted = employeeRepo.deleteEmployeeByNameAndPosition(name, position);
        }
        if (isDeleted){
            System.out.println("Employee was deleted");
        }else {
            System.out.println("Employee was not deleted");
        }
        return isDeleted;
    }

    public EmployeeDTO updateEmployee(String name, EmployeeDTO employeeDTO) {
        EmployeeDTO employeeDTOupdated = null;
        if (employeeValidator.isNameValid(name) && employeeValidator.isPositionValid(employeeDTO.getPosition()) &&
                employeeValidator.isAgeValid(employeeDTO.getAge())){
            Employee employee = employeeMapper.convertEmployeeDTOToEmployee(employeeDTO);
            employeeDTOupdated = employeeMapper.convertEmployeeToEmployeeDTO(employeeRepo.updateEmployee(name, employee));
        }else {
            System.out.println("Employee was not updated! ");
        }
        return employeeDTOupdated;
    }
}
