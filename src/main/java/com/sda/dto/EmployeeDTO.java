package com.sda.dto;

public class EmployeeDTO {

    private String name;
    private String position;
    private Integer age;
    /*private Department department;*/

    /*public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Angajatul este: " + name + " " + position + " " + age;
    }
}
