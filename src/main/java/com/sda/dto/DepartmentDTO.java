package com.sda.dto;

import com.sda.entities.Manager;
import org.springframework.stereotype.Service;

@Service
public class DepartmentDTO {

    private String name;

    private Manager manager;

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "DepartmentDTO{" +
                "name='" + name + '\'' +
                ", manager=" + manager +
                '}';
    }
}
