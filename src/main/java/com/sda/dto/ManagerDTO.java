package com.sda.dto;

import com.sda.entities.Department;

public class ManagerDTO extends EmployeeDTO {

    private Department departmentManaged;

    public Department getDepartmentManaged() {
        return departmentManaged;
    }

    public void setDepartmentManaged(Department departmentManaged) {
        this.departmentManaged = departmentManaged;
    }

    @Override
    public String toString() {
        return "Managerul are numele: " + " " + super.getName() + " ocupa pozitia " + super.getPosition()
                + " si are varsta de " + super.getAge() + " si este managerul departamentului " + getDepartmentManaged();
    }
}
