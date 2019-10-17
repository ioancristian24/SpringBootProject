package com.sda.implementationDAO.implementation;

import com.sda.entities.Department;
import com.sda.implementationDAO.DepartmentDAO;
import com.sda.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentDaoImpl implements DepartmentDAO {

    @Override
    public void addDepartment(Department department) {

    }

    @Override
    public Department displayDepartmentById(Integer id) {
        return null;
    }

    public List<Department> displayAllDepartements(){
        System.out.println("Am ajuns in clasa DepartmentDaoImpl");
        List<Department> departmentList = new ArrayList<>();
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            String HQL = "FROM Department";
            Query query = session.createQuery(HQL);
            departmentList = query.list();
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return departmentList;
    }

    @Override
    public Department updateDepartmentById(Integer id, String name) {
        return null;
    }

    @Override
    public void deleteDepartmentById(Integer id) {

    }
}
