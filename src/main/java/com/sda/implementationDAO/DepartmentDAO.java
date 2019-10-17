package com.sda.implementationDAO;

import com.sda.entities.Department;

public interface DepartmentDAO {

    void addDepartment(Department department);
    Department displayDepartmentById(Integer id);
    Department updateDepartmentById(Integer id, String name);
    void deleteDepartmentById(Integer id);
}
