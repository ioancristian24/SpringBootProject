package com.sda.services;

import com.sda.dto.DepartmentDTO;
import com.sda.entities.Department;
import com.sda.entities.Employee;
import com.sda.mapper.DepartmentMapper;
import com.sda.repositories.DepartmentRepo;
import com.sda.validators.DepartmentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    private DepartmentRepo departmentRepo;

    @Autowired
    private DepartmentValidator departmentValidator;

    @Autowired
    private DepartmentMapper departmentMapper;

    public DepartmentRepo getDepartmentRepo() {
        return departmentRepo;
    }

    @Autowired
    public void setDepartmentRepo(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    /*public List<DepartmentDTO> displayDepartmentsDTO() {

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
    }*/

    public List<DepartmentDTO> displayAllDepartments(){
        List<Department> departmentList = getDepartmentRepo().readAllDepartments();
        List<DepartmentDTO> departmentDTOList = new ArrayList<>();
        for (Department department : departmentList){
            departmentDTOList.add(departmentMapper.convertDepartmentToDepartmentDTO(department));
        }
        return departmentDTOList;
    }

    public DepartmentDTO addDepartment(DepartmentDTO departmentDTO){
        if (departmentValidator.isDTOValid(departmentDTO)){
            Department department = departmentMapper.convertDepartemntDTOToDepartemnt(departmentDTO);

            getDepartmentRepo().createDepartement(department);
            DepartmentDTO departmentDTO1 = departmentMapper.convertDepartmentToDepartmentDTO(department);
        }else {
            System.out.println("Valorile introduse nu indeplinesc conditiile de eligibilitate. ");
        }
        return departmentDTO;
    }

    public List<DepartmentDTO> displayDepartmentByName(String name) {
        List<DepartmentDTO>departmentDTOList = new ArrayList<>();
        if (departmentValidator.isNameValid(name)) {
            List<Department>departmentList = departmentRepo.displayDepartmentByName(name);
            for (Department department : departmentList){
                departmentDTOList.add(departmentMapper.convertDepartmentToDepartmentDTO(department));
            }
        }else {
            System.out.println("Name of department is not valid! ");
        }
        return departmentDTOList;
    }

    public boolean deleteDepartmentByName(String name) {
        boolean isDeleted = false;
        if (departmentValidator.isNameValid(name)){
            isDeleted = departmentRepo.deleteDepartmentByName(name);
        }
        if (isDeleted){
            System.out.println("Department was deleted !");
        }
        if (!isDeleted){
            System.out.println("Department was not deleted !");
        }
        return isDeleted;
    }
}
