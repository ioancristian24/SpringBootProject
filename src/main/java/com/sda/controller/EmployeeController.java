package com.sda.controller;

import com.sda.dto.EmployeeDTO;
import com.sda.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    @ResponseBody
    public ResponseEntity displayEmployees(){

        List<EmployeeDTO> employeeDTOList =  employeeService.displayAllEmployees();

        return new ResponseEntity(employeeDTOList, HttpStatus.OK);
    }

}
