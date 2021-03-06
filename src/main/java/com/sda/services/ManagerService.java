package com.sda.services;

import com.sda.dto.ManagerDTO;
import com.sda.entities.Manager;
import com.sda.mapper.ManagerMapper;
import com.sda.repositories.ManagerRepo;
import com.sda.validators.ManagerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerService {

    @Autowired
    private ManagerValidator managerValidator;

    @Autowired
    private ManagerMapper managerMapper;

    private ManagerRepo managerRepo;

    public ManagerRepo getManagerRepo() {
        return managerRepo;
    }

    @Autowired
    public void setManagerRepo(ManagerRepo managerRepo) {
        this.managerRepo = managerRepo;
    }

    /*public List<ManagerDTO> displayManagers(){
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
    }*/

    public List<ManagerDTO> displayAllManagers(){
        List<Manager> managerList = getManagerRepo().readAllManagers();
        List<ManagerDTO> managerDTOList = new ArrayList<>();
        for (Manager manager : managerList){
            managerDTOList.add(managerMapper.convertManagerToManagerDTO(manager));
        }
        return managerDTOList;
    }

    public ManagerDTO addManager(ManagerDTO managerDTO) {
        System.out.println("Am ajuns in clasa ManagerService! ");
        ManagerDTO managerDTO1 = null;
        if (managerValidator.isValidDTO(managerDTO)){
            Manager manager = managerMapper.convertManagerDTOToManager(managerDTO);
            Manager manager1 = getManagerRepo().createManager(manager);

            managerDTO1 = managerMapper.convertManagerToManagerDTO(manager1);
        }else {
            System.out.println("Valorile introduse nu indeplinesc conditiile de eligibilitate. ");
        }
        return managerDTO1;
    }
}
