package com.sda.repositories;

import com.sda.entities.Department;
import com.sda.implementationDAO.implementation.DepartmentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentRepo {

    private DepartmentDaoImpl departmentDAO;

    public DepartmentDaoImpl getDepartmentDAO() {
        return departmentDAO;
    }

    @Autowired
    public void setDepartmentDAO(DepartmentDaoImpl departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    public Department createDepartement(Department department){
        System.out.println("Am ajuns in clasa DepartmentRepo");
        getDepartmentDAO().addDepartment(department);
        return department;
    }

    public List<Department> readAllDepartments(){
        List<Department> departmentList = getDepartmentDAO().displayAllDepartements();
        return departmentList;
    }

    public List<Department> displayDepartmentByName(String name) {
        List<Department> departmentList = getDepartmentDAO().displayDepartmentByName(name);
        return departmentList;
    }

    public boolean deleteDepartmentByName(String name) {
        return departmentDAO.deleteDepartmentByName(name);
    }
}
