package com.sda.mapper;

import com.sda.dto.DepartmentDTO;
import com.sda.entities.Department;
import org.springframework.stereotype.Component;

@Component
public class DepartmentMapper {

    public DepartmentDTO convertDepartmentToDepartmentDTO(Department department){
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(department.getName());
        /*departmentDTO.setEmployeeList(department.getEmployeeList());*/
        return departmentDTO;
    }

    public Department convertDepartemntDTOToDepartemnt(DepartmentDTO departmentDTO){
        Department department = new Department();
        department.setName(departmentDTO.getName());
        return department;
    }
}
