package com.sda.controller;

import com.sda.dto.DepartmentDTO;
import com.sda.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/departments")
    @ResponseBody
    public ResponseEntity displayDepartments(){

        List<DepartmentDTO> departmentDTOList = departmentService.displayAllDepartments();

        return new ResponseEntity(departmentDTOList, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json", path = "/addDepartment")
    public DepartmentDTO addDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO departmentDTO1 = departmentService.addDepartment(departmentDTO);

        return departmentDTO1;
    }

    @GetMapping("/departments/{name}")
    public List<DepartmentDTO> displayDepartmentByName(@PathVariable String name){
        System.out.println("Numele departmentului este: " + name);
        List<DepartmentDTO>departmentDTOList = departmentService.displayDepartmentByName(name);
        return departmentDTOList;
    }

    @DeleteMapping("/deleteDepartments/{name}")
    public ResponseEntity<String> deleteDepartmentByName(@PathVariable String name){
        boolean isDeleted = departmentService.deleteDepartmentByName(name);
        if (!isDeleted){
            return new ResponseEntity<>("S-au gasit mai multe departmente cu acelasi nume sau departementul cu acest nume nu exista! ",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Stergerea a fost efectuata cu succes! ", HttpStatus.OK);
    }


}
