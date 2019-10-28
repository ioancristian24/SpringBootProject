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
    public Department addDepartment(Department department) {
        System.out.println("Am ajuns in clasa DepartmentDaoImpl");
        Department department1 = null;
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Integer id = (Integer) session.save(department);
            System.out.println("Department was created with id " + id);
            session.getTransaction().commit();
            if (id != null){
                department1 = session.get(Department.class, id);
            }else {
                System.out.println("Department was not created! ");
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return department1;
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

    public List<Department> displayDepartmentByName(String name) {
        List<Department>departmentList = new ArrayList<>();
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            String HQL = "FROM Department WHERE name LIKE: name";
            Query query = session.createQuery(HQL);
            query.setParameter("name", "%" + name + "%");
            departmentList = query.list();
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return departmentList;
    }

    public boolean deleteDepartmentByName(String name) {
        boolean isDeleted = false;
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            String countHQL = "SELECT COUNT (*) FROM Department WHERE name=: name";
            Query countQuery = session.createQuery(countHQL);
            countQuery.setParameter("name", name);
            Long countResult = (Long) countQuery.uniqueResult();
            if (countResult != 1){
                isDeleted = false;
            }else {
                String deleteHQL = "DELETE FROM Department WHERE name =: name";
                Query deleteQuery = session.createQuery(deleteHQL);
                deleteQuery.setParameter("name", name);
                Integer deleteResult = deleteQuery.executeUpdate();
                if (deleteResult != 1){
                    isDeleted = false;
                }else {
                    isDeleted = true;
                }
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return isDeleted;
    }
}
