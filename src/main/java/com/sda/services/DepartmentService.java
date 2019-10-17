package com.sda.services;

import com.sda.dto.DepartmentDTO;
import com.sda.entities.Department;
import com.sda.mapper.DepartmentMapper;
import com.sda.repositories.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepo departmentRepo;

    @Autowired
    private DepartmentMapper departmentMapper;

    public DepartmentRepo getDepartmentRepo() {
        return departmentRepo;
    }

    @Autowired
    public void setDepartmentRepo(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public List<DepartmentDTO> displayDepartmentsDTO() {

        List<DepartmentDTO> departmentDTOList = new ArrayList<>();

        DepartmentDTO departmentDTO1 = new DepartmentDTO();
        departmentDTO1.setName("HR");

        DepartmentDTO departmentDTO2 = new DepartmentDTO();
        departmentDTO2.setName("Marketing");

        DepartmentDTO departmentDTO3 = new DepartmentDTO();
        departmentDTO3.setName("Management");

        departmentDTOList.add(departmentDTO1);
        departmentDTOList.add(departmentDTO2);
        departmentDTOList.add(departmentDTO3);
        return departmentDTOList;
    }

    public List<DepartmentDTO> displayAllDepartments(){
        List<Department> departmentList = getDepartmentRepo().readAllDepartments();
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        for (Department department : departmentList){
            departmentDTOList.add(departmentMapper.convertDepartmentToDepartmentDTO(department));
        }
        return departmentDTOList;
    }
}
