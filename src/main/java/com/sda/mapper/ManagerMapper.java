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
        managerDTO.setDepartmentManaged(manager.getDepartment());
        return managerDTO;
    }
}
