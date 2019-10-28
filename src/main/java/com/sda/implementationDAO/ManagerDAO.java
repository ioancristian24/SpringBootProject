package com.sda.implementationDAO;

import com.sda.entities.Manager;

public interface ManagerDAO {

    Manager addManager(Manager manager);
    Manager displayManagerById(Integer id);
    Manager updateManagerById(Integer id, String position);
    void deleteManagerById(Integer id);
}
