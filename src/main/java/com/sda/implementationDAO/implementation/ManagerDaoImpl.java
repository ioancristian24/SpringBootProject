package com.sda.implementationDAO.implementation;

import com.sda.entities.Manager;
import com.sda.implementationDAO.ManagerDAO;
import com.sda.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManagerDaoImpl implements ManagerDAO {


    @Override
    public Manager addManager(Manager manager) {
        System.out.println("Am ajuns in clasa ManagerDaoImpl");
        Manager manager1 = null;
        try(Session session = HibernateUtils.getSessionFactory().openSession()) {
            session.beginTransaction();
            Integer id = (Integer) session.save(manager);
            System.out.println("Manager was created with id " + id);
            session.getTransaction().commit();
            if (id != null){
                manager1 = session.get(Manager.class, id);
            }else {
                System.out.println("Manager was not created !");
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return manager1;
    }

    @Override
    public Manager displayManagerById(Integer id) {
        return null;
    }

    public List<Manager> displayAllManagers(){
        System.out.println("Am ajuns in clasa ManagerDaoImpl.");
        List<Manager> managerList = new ArrayList<>();
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            String HQL = "FROM Manager";
            Query query = session.createQuery(HQL);
            managerList = query.list();
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return managerList;
    }

    @Override
    public Manager updateManagerById(Integer id, String position) {
        return null;
    }

    @Override
    public void deleteManagerById(Integer id) {

    }
}
