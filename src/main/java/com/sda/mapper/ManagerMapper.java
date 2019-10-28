package com.sda.mapper;

import com.sda.dto.ManagerDTO;
import com.sda.entities.Manager;
import org.springframework.stereotype.Component;

@Component
public class ManagerMapper {

    public ManagerDTO convertManagerToManagerDTO(Manager manager){
        ManagerDTO managerDTO = new ManagerDTO();
        managerDTO.setAge(manager.getAge());
        managerDTO.setName(manager.getName());
        managerDTO.setPosition(manager.getPosition());
        /*managerDTO.setDepartment(manager.getDepartment());*/
        return managerDTO;
    }

    public Manager convertManagerDTOToManager(ManagerDTO managerDTO){
        Manager manager = new Manager();
        manager.setName(managerDTO.getName());
        manager.setAge(managerDTO.getAge());
        manager.setPosition(managerDTO.getPosition());
        return manager;
    }
}
