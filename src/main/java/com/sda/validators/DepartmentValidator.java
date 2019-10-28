package com.sda.validators;

import com.sda.dto.DepartmentDTO;
import org.springframework.stereotype.Component;

@Component
public class DepartmentValidator {

    public boolean isNameValid(String name){
        if (name == null){
            return false;
        }
        if (name.isEmpty()){
            return false;
        }
        if(!name.matches("([A-Z a-z])*")){
            return false;
        }
        return true;
    }

    public boolean isDTOValid(DepartmentDTO departmentDTO){
        if(isNameValid(departmentDTO.getName()) == true){
            return true;
        }
        return false;
    }
}
