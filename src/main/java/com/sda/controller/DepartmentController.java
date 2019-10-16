package com.sda.controller;

import com.sda.dto.DepartmentDTO;
import com.sda.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/departments")
    @ResponseBody
    public ResponseEntity displayDepartments(){

        List<DepartmentDTO> departmentDTOList = departmentService.displayDepartmentsDTO();

        return new ResponseEntity(departmentDTOList, HttpStatus.OK);
    }
}
