package com.sda.repositories;

import com.sda.entities.Manager;
import com.sda.implementationDAO.implementation.ManagerDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerRepo {

    private ManagerDaoImpl managerDao;

    public ManagerDaoImpl getManagerDao() {
        return managerDao;
    }
    @Autowired
    public void setManagerDao(ManagerDaoImpl managerDao) {
        this.managerDao = managerDao;
    }

    public List<Manager> readAllManagers(){
        List<Manager> managerList = getManagerDao().displayAllManagers();
        return managerList;
    }

    public Manager createManager(Manager manager) {
        System.out.println("Am ajuns in clasa ManagerRepo");
        getManagerDao().addManager(manager);
        return manager;
    }
}
