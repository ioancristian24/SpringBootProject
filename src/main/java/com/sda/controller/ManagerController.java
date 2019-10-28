package com.sda.controller;

import com.sda.dto.ManagerDTO;
import com.sda.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @RequestMapping("/managers")
    @ResponseBody
    public ResponseEntity displayManagers(){

        List<ManagerDTO> managerDTOList = managerService.displayAllManagers();

        return new ResponseEntity(managerDTOList, HttpStatus.OK);
    }

    @PostMapping(consumes = "application/json", produces = "application/json", path = "/addManager")
    public ManagerDTO addManager(@RequestBody ManagerDTO managerDTO){

        ManagerDTO managerDTO1 = managerService.addManager(managerDTO);
        return managerDTO1;
    }
}
