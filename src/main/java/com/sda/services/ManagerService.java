package com.sda.services;

import com.sda.dto.ManagerDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {

    public List<ManagerDTO> displayManagers(){
        List<ManagerDTO> managerDTOList = new ArrayList<>();

        ManagerDTO managerDTO1 = new ManagerDTO();
        managerDTO1.setName("Anton");
        managerDTO1.setDepartmentManaged("Marketing");
        managerDTO1.setPosition("Executive Manager");
        managerDTO1.setAge(33);

        ManagerDTO managerDTO2 = new ManagerDTO();
        managerDTO2.setName("Rusu");
        managerDTO2.setDepartmentManaged("HR");
        managerDTO2.setPosition("Recruitment Manager");
        managerDTO2.setAge(40);

        managerDTOList.add(managerDTO1);
        managerDTOList.add(managerDTO2);
        return managerDTOList;
    }
}
