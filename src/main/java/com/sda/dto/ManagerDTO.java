package com.sda.dto;

public class ManagerDTO extends EmployeeDTO {

    private String departmentManaged;

    public String getDepartmentManaged() {
        return departmentManaged;
    }

    public void setDepartmentManaged(String departmentManaged) {
        this.departmentManaged = departmentManaged;
    }

    @Override
    public String toString() {
        return "Managerul are numele: " + " " + super.getName() + " ocupa pozitia " + super.getPosition()
                + " si are varsta de " + super.getAge() + " si este managerul departamentului " + getDepartmentManaged();
    }
}
