package com.sda.implementationDAO.implementation;

import com.sda.entities.Employee;
import com.sda.implementationDAO.EmployeeDAO;
import com.sda.utils.HibernateUtils;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeDaoImpl implements EmployeeDAO {


    @Override
    public void addEmployee(Employee employee) {
        System.out.println("Am ajuns in clasa EmployeeDaoImpl.");
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            Integer id = (Integer) session.save(employee);
            System.out.println("Employee was creates with id: " + id);
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    @Override
    public Employee displayEmployeeById(Integer id) {
        return null;
    }

    public List<Employee> displayAllEmployees(){
        System.out.println("Am ajuns in clasa EmployeeDaoImpl");
        List<Employee> employeeList = new ArrayList<>();
        try(Session session = HibernateUtils.getSessionFactory().openSession()){
            session.beginTransaction();
            String HQL = "FROM Employee";
            Query query = session.createQuery(HQL);
            employeeList = query.list();
            session.getTransaction().commit();
        }catch (HibernateException e){
            e.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public Employee updateEmployeeById(Integer id, String position) {
        return null;
    }

    @Override
    public void deleteEmployeeById(Integer id) {

    }
}
