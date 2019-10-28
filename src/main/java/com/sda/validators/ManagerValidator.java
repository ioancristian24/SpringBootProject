package com.sda.validators;

import com.sda.dto.ManagerDTO;
import org.springframework.stereotype.Component;

@Component
public class ManagerValidator {

    public boolean isNameValid(String name){
        if (name == null){
            System.out.println("Name is null");
            return false;
        }
        if (name.isEmpty()){
            System.out.println("Name is empty");
            return false;
        }
        if (!name.matches("([A-Z a-z])*")){
            System.out.println("Name is not in interval");
            return false;
        }
        return true;
    }

    public boolean isAgeValid(Integer age){
        if (age == null){
            System.out.println("Age is null");
            return false;
        }
        if (age < 18 || age > 100){
            System.out.println("Age is not in interval");
            return false;
        }
        return true;
    }

    public boolean isPositionValid(String position){
        if (position == null){
            System.out.println("Position is null");
            return false;
        }
        if (position.isEmpty()){
            System.out.println("Position is not in interval");
            return false;
        }
        if (!position.matches("([A-Z a-z])*")){
            System.out.println("Position is not matches");
            return false;
        }
        return true;
    }

    public boolean isDepartmentManagedValid(String departmentManaged){
        if (departmentManaged == null){
            return false;
        }
        if (departmentManaged.isEmpty()){
            return false;
        }
        if (!departmentManaged.matches("([A-Z a-z])*")){
            return false;
        }
        return true;
    }

    public boolean isValidDTO(ManagerDTO managerDTO){
        if (isNameValid(managerDTO.getName()) == true && isAgeValid(managerDTO.getAge()) == true
                && isPositionValid(managerDTO.getPosition()) == true
                   /*&& isDepartmentManagedValid(managerDTO.getDepartmentManaged()) == true*/){
            return true;
        }
        return false;
    }
}
