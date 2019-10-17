package com.sda.implementationDAO;

import com.sda.entities.Manager;

public interface ManagerDAO {

    void addManager(Manager manager);
    Manager displayManagerById(Integer id);
    Manager updateManagerById(Integer id, String position);
    void deleteManagerById(Integer id);
}
