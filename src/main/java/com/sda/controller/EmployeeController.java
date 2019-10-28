package com.sda.controller;

import com.sda.dto.EmployeeDTO;
import com.sda.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employees")
    @ResponseBody
    public ResponseEntity displayEmployees(){

        List<EmployeeDTO> employeeDTOList =  employeeService.displayAllEmployees();

        return new ResponseEntity(employeeDTOList, OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json", path = "/addEmployee")
    public EmployeeDTO addEmployee(@RequestBody EmployeeDTO employeeDTO){

        EmployeeDTO employeeDTO1 = employeeService.addEmployee(employeeDTO);

        return employeeDTO1;
    }

    @GetMapping("/employees/{name}")
    public List<EmployeeDTO> displayEmployeeByName(@PathVariable String name){
        System.out.println("Numele angajatului este: " + name);
        List<EmployeeDTO> employeeDTOList = employeeService.displayEmployeeDTOByName(name);
        return employeeDTOList;
    }

    @GetMapping("employees/name/{name}/position/{position}")
    public List<EmployeeDTO> displayEmployeesByNameAndPosition(@PathVariable String name, @PathVariable String position){
        System.out.println("Numele angajatului este: " + name + " si pozitia este " + position);
        List<EmployeeDTO>employeeDTOList = employeeService.displayEmployeeDTOByNameAndPosition(name, position);
        return employeeDTOList;
    }

    @DeleteMapping("/deleteEmployee/{name}")
    public ResponseEntity<String> deleteEmployeeByName(@PathVariable String name){
        boolean isDeleted = employeeService.deleteEmployeeByName(name);
        if (!isDeleted){
            return new ResponseEntity<>("S-au gasit mai multi employees cu acest nume sau nu s-a gasit nici un nume ",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Stergere efectuata cu succes !", HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/deleteEmployee/name/{name}/position/{position}")
    public ResponseEntity<String> deleteEmployeeByNameAndPosition(@PathVariable String name, @PathVariable String position){
        boolean isDeleted = employeeService.deleteEmployeeByNameAndPosition(name, position);
        if (!isDeleted){
            return new ResponseEntity<>("S-au gasit mai multi employees cu acest nume sau angajatul cu acest nume nu exista !",
                    HttpStatus.BAD_REQUEST);
        }else {
            return new ResponseEntity<>("Stergere efectuata cu succes!", HttpStatus.ACCEPTED);
        }
    }

    @PutMapping(path = "/updateEmployee/{name}", consumes = "application/json", produces = "application/json")
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable String name){
        System.out.println(name);
        System.out.println(employeeDTO.getPosition() + " "  + employeeDTO.getAge());
        EmployeeDTO employeeDTOupdated = employeeService.updateEmployee(name, employeeDTO);
        return employeeDTOupdated;
    }
}
