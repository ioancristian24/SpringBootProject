package com.sda.dto;

public class DepartmentDTO {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Numele departamentului este: " + name;
    }
}
